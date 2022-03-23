package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import org.springframework.stereotype.Service;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PriceAssemblerImplementation.getPriceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Service
public class ServiceSaveReservation
{
    private final ReservationRepository reservationRepository;
    private final PlaceRepository placeRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;

    public ServiceSaveReservation(ReservationRepository reservationRepository, PlaceRepository placeRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository)
    {
        this.reservationRepository = reservationRepository;
        this.placeRepository = placeRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
    }

    public void save(Reservation reservation)
    {
        checkPlaceDoesNotExists(reservation.getPlace());
        checkPaymentMethodDoesNotExists(reservation.getPaymentMethod());
        checkUserDoesNotExists(reservation.getUser());
        checkPlaceIsTaken(reservation.getPlace());

        var price = calculatePrice(reservation.getReservedTime().getValue());
        var departureTime = calculateDepartureTime(reservation.getArrivalTime(), reservation.getReservedTime().getTypeTime(), reservation.getReservedTime().getValue());

        var reservationDTO = getReservationAssembler().assembleDTOFromDomain(reservation);
        reservationDTO.setPrice(getPriceAssembler().assembleDTOFromDomain(price));
        reservationDTO.setDepartureTime(departureTime);

        this.reservationRepository.save(getReservationAssembler().assembleDomainFromDTO(reservationDTO));
        this.placeRepository.modify(reservation.getPlace().getCode(), getPlaceAssembler().assembleDomainFromDTO(reservationDTO.getPlace(), true));
    }

    private void checkPlaceIsTaken(Place place)
    {
        var object = this.placeRepository.getByPosition(place.getPosition());

        if(object.isTaken())
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_PLACE_IS_TAKEN);
        }
    }

    private void checkPlaceDoesNotExists(Place place)
    {
        if(!this.placeRepository.exists(place))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_PLACE_DOES_NOT_EXISTS);
        }
    }

    private void checkPaymentMethodDoesNotExists(PaymentMethod paymentMethod)
    {
        if(!this.paymentMethodRepository.exists(paymentMethod))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS);
        }
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(getUserAssembler().assembleSummaryDTOFromDomain(user)))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_USER_DOES_NOT_EXISTS);
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
}