package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.*;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceSaveReservation;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilDate;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveReservation
{
    private final ServiceSaveReservation serviceSaveReservation;

    public ServiceApplicationSaveReservation(ServiceSaveReservation serviceSaveReservation)
    {
        this.serviceSaveReservation = serviceSaveReservation;
    }

    public void save(ReservationDTO reservationDTO)
    {
        this.serviceSaveReservation.save(assembleReservation(reservationDTO));
    }

    private Reservation assembleReservation(ReservationDTO reservation)
    {
        return Reservation.create(reservation.getCode(), UtilDate.getSpecificDate(reservation.getDate()), reservation.getArrivalTime(), reservation.getDepartureTime(), assembleReservedTime(reservation.getReservedTime()), assemblePrice(reservation.getPrice()), assemblePlace(reservation.getPlace()), assemblePaymentMethod(reservation.getPaymentMethod()), assembleUser(reservation.getUser()));
    }

    private ReservedTime assembleReservedTime(ReservedTimeDTO reservedTime)
    {
        return ReservedTime.create(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private Price assemblePrice(PriceDTO price)
    {
        return Price.create(price.getCode(), price.getValue());
    }

    private Place assemblePlace(PlaceDTO place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceDTO typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethod assemblePaymentMethod(PaymentMethodDTO paymentMethod)
    {
        return PaymentMethod.create(paymentMethod.getCode(), paymentMethod.getName());
    }

    private User assembleUser(UserDTO user)
    {
        return User.create(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRole(user.getUserRole()), assembleVehicle(user.getVehicle()));
    }

    private UserRole assembleUserRole(UserRoleDTO userRole)
    {
        return UserRole.create(userRole.getCode(), userRole.getName());
    }

    private Vehicle assembleVehicle(VehicleDTO vehicle)
    {
        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicleDTO typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }
}