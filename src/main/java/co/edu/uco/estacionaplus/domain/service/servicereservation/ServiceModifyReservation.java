package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.*;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import org.springframework.stereotype.Service;

@Service
public class ServiceModifyReservation
{
    private static final String MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS = "This payment method doesn't exists";
    private static final String MESSAGE_PLACE_IS_TAKEN = "This place was taken by someone else";

    private final ReservationRepository reservationRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PlaceRepository placeRepository;

    public ServiceModifyReservation(ReservationRepository reservationRepository, PaymentMethodRepository paymentMethodRepository, PlaceRepository placeRepository)
    {
        this.reservationRepository = reservationRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.placeRepository = placeRepository;
    }

    public void modify(int code, Reservation reservation)
    {
        checkPaymentMethodDoesNotExists(reservation.getPaymentMethod());
        checkPlaceIsTaken(reservation.getPlace());
        var price = calculatePrice(reservation.getReservedTime().getValue());
        var departureTime = calculateDepartureTime(reservation.getArrivalTime(), reservation.getReservedTime().getTypeTime(), reservation.getReservedTime().getValue());

        this.reservationRepository.modify(code, assembleReservation(reservation, price, departureTime));
    }

    private void checkPaymentMethodDoesNotExists(PaymentMethod paymentMethod)
    {
        if(!this.paymentMethodRepository.exists(paymentMethod))
        {
            throw new IllegalArgumentException(MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS);
        }
    }

    private void checkPlaceIsTaken(Place place)
    {
        var object = this.placeRepository.getByPosition(place.getPosition());

        if(object.isTaken())
        {
            throw new IllegalArgumentException(MESSAGE_PLACE_IS_TAKEN);
        }
    }

    private static String calculateDepartureTime(String arrivalTime, String typeTime, int value)
    {
        String departureTime = "00:00:00";
        int hours = 0;
        int minutes = 0;

        int finalHour = 0;

        for(var i = 0; i < arrivalTime.length(); i++)
        {
            if(UtilNumber.isNumberTheSame(i, 0))
            {
                hours = concatenateCharacters(i, arrivalTime);
            }

            if(UtilNumber.isNumberTheSame(i, 3))
            {
                minutes = concatenateCharacters(i, arrivalTime);
            }
        }

        if(typeTime.equals("Hora"))
        {
            finalHour = hours + value;
        }

        if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 1)
        {
            departureTime = "0" + finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 1)
        {
            departureTime = finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 2)
        {
            departureTime = "0" + finalHour + ":" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 2)
        {
            departureTime = finalHour + ":" + minutes + ":00";
        }

        return departureTime;
    }

    private static int concatenateCharacters(int index, String arrivalTime)
    {
        return Integer.parseInt("" + arrivalTime.charAt(index) + arrivalTime.charAt(index+1));
    }

    private Price calculatePrice(int arrivalTime)
    {
        return Price.create(0, (double) 2000 * arrivalTime);
    }

    private Reservation assembleReservation(Reservation reservation, Price price, String departureTime)
    {
        return Reservation.create(reservation.getCode(), reservation.getDate(), reservation.getArrivalTime(), departureTime, assembleReservedTime(reservation.getReservedTime()), price, assemblePlace(reservation.getPlace()), assemblePaymentMethod(reservation.getPaymentMethod()), assembleUser(reservation.getUser()));
    }

    private ReservedTime assembleReservedTime(ReservedTime reservedTime)
    {
        return ReservedTime.create(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private Place assemblePlace(Place place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlace typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethod assemblePaymentMethod(PaymentMethod paymentMethod)
    {
        return PaymentMethod.create(paymentMethod.getCode(), paymentMethod.getName());
    }

    private User assembleUser(User user)
    {
        return User.create(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRole(user.getUserRole()), assembleVehicle(user.getVehicle()));
    }

    private UserRole assembleUserRole(UserRole userRole)
    {
        return UserRole.create(userRole.getCode(), userRole.getName());
    }

    private Vehicle assembleVehicle(Vehicle vehicle)
    {
        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicle typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }
}