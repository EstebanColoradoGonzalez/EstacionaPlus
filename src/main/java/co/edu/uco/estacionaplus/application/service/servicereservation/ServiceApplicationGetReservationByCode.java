package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.*;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceGetReservationByCode;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilDate;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetReservationByCode
{
    private final ServiceGetReservationByCode serviceGetReservationByCode;

    public ServiceApplicationGetReservationByCode(ServiceGetReservationByCode serviceGetReservationByCode)
    {
        this.serviceGetReservationByCode = serviceGetReservationByCode;
    }

    public ReservationDTO getByCode(int code)
    {
        return assembleReservationDTO(this.serviceGetReservationByCode.getByCode(code));
    }

    private ReservationDTO assembleReservationDTO(Reservation reservation)
    {
        return new ReservationDTO(reservation.getCode(), UtilDate.getStringDate(reservation.getDate()), reservation.getArrivalTime(), reservation.getDepartureTime(), assembleReservedTimeDTO(reservation.getReservedTime()), assemblePriceDTO(reservation.getPrice()), assemblePlaceDTO(reservation.getPlace()), assemblePaymentMethodDTO(reservation.getPaymentMethod()), assembleUserDTO(reservation.getUser()));
    }

    private ReservedTimeDTO assembleReservedTimeDTO(ReservedTime reservedTime)
    {
        return new ReservedTimeDTO(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private PriceDTO assemblePriceDTO(Price price)
    {
        return new PriceDTO(price.getCode(), price.getValue());
    }

    private PlaceDTO assemblePlaceDTO(Place place)
    {
        return new PlaceDTO(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlaceDTO(place.getTypePlace()));
    }

    private TypePlaceDTO assembleTypePlaceDTO(TypePlace typePlace)
    {
        return new TypePlaceDTO(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethodDTO assemblePaymentMethodDTO(PaymentMethod paymentMethod)
    {
        return new PaymentMethodDTO(paymentMethod.getCode(), paymentMethod.getName());
    }

    private UserDTO assembleUserDTO(User user)
    {
        return new UserDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRoleDTO(user.getUserRole()), assembleVehicleDTO(user.getVehicle()));
    }

    private UserRoleDTO assembleUserRoleDTO(UserRole userRole)
    {
        return new UserRoleDTO(userRole.getCode(), userRole.getName());
    }

    private VehicleDTO assembleVehicleDTO(Vehicle vehicle)
    {
        return new VehicleDTO(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleDTO(vehicle.getTypeVehicle()));
    }

    private TypeVehicleDTO assembleTypeVehicleDTO(TypeVehicle typeVehicle)
    {
        return new TypeVehicleDTO(typeVehicle.getCode(), typeVehicle.getName());
    }
}