package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.*;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PaymentMethodDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ReservationDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryPostgreSQL implements ReservationRepository
{
    private final ReservationDAO reservationDAO;
    private final UserDAO userDAO;
    private final PaymentMethodDAO paymentMethodDAO;
    private final PlaceDAO placeDAO;

    public ReservationRepositoryPostgreSQL(ReservationDAO reservationDAO, UserDAO userDAO, PaymentMethodDAO paymentMethodDAO, PlaceDAO placeDAO)
    {
        this.reservationDAO = reservationDAO;
        this.userDAO = userDAO;
        this.paymentMethodDAO = paymentMethodDAO;
        this.placeDAO = placeDAO;
    }

    @Override
    public Reservation getByCode(int code)
    {
        return this.reservationDAO.findById(code).map(this::assembleReservation).orElse(null);
    }

    @Override
    public void save(Reservation reservation)
    {
        var user = this.userDAO.findById(reservation.getUser().getCode()).map(this::assembleUserEntity).orElse(null);
        var paymentMethod = this.paymentMethodDAO.findById(reservation.getPaymentMethod().getCode()).map(this::assemblePaymentMethodEntity).orElse(null);
        var place = this.placeDAO.findById(reservation.getPlace().getCode()).map(this::assemblePlaceEntity).orElse(null);

        this.reservationDAO.save(assembleReservationEntity(reservation, user, paymentMethod, place));
    }

    @Override
    public void modify(int code, Reservation reservation)
    {
        this.reservationDAO.save(assembleReservationEntity(code, reservation));
    }

    @Override
    public void delete(int code)
    {
        this.reservationDAO.deleteById(code);
    }

    @Override
    public boolean exists(Reservation reservation)
    {
        return this.reservationDAO.existsById(reservation.getCode());
    }

    private Reservation assembleReservation(ReservationEntity reservation)
    {
        return Reservation.create(reservation.getCode(), reservation.getDate(), reservation.getArrivalTime(), reservation.getDepartureTime(), assembleReservedTime(reservation.getReservedTime()), assemblePrice(reservation.getPrice()), assemblePlace(reservation.getPlace()), assemblePaymentMethod(reservation.getPaymentMethod()), assembleUser(reservation.getUser()));
    }

    private ReservedTime assembleReservedTime(ReservedTimeEntity reservedTime)
    {
        return ReservedTime.create(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private Price assemblePrice(PriceEntity price)
    {
        return Price.create(price.getCode(), price.getValue());
    }

    private Place assemblePlace(PlaceEntity place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceEntity typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethod assemblePaymentMethod(PaymentMethodEntity paymentMethod)
    {
        return PaymentMethod.create(paymentMethod.getCode(), paymentMethod.getName());
    }

    private User assembleUser(UserEntity user)
    {
        return User.create(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRole(user.getUserRole()), assembleVehicle(user.getVehicle()));
    }

    private UserRole assembleUserRole(UserRoleEntity userRole)
    {
        return UserRole.create(userRole.getCode(), userRole.getName());
    }

    private Vehicle assembleVehicle(VehicleEntity vehicle)
    {
        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicleEntity typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }

    private ReservationEntity assembleReservationEntity(Reservation reservation, UserEntity user, PaymentMethodEntity paymentMethod, PlaceEntity place)
    {
        return new ReservationEntity(reservation.getCode(), reservation.getDate(), reservation.getArrivalTime(), reservation.getDepartureTime(), assembleReservedTimeEntity(reservation.getReservedTime()), assemblePriceEntity(reservation.getPrice()), assemblePlaceEntity(place), assemblePaymentMethodEntity(paymentMethod), assembleUserEntity(user));
    }

    private ReservedTimeEntity assembleReservedTimeEntity(ReservedTime reservedTime)
    {
        return new ReservedTimeEntity(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private PriceEntity assemblePriceEntity(Price price)
    {
        return new PriceEntity(price.getCode(), price.getValue());
    }

    private PlaceEntity assemblePlaceEntity(PlaceEntity place)
    {
        return new PlaceEntity(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlaceEntity(place.getTypePlace()));
    }

    private TypePlaceEntity assembleTypePlaceEntity(TypePlaceEntity typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethodEntity assemblePaymentMethodEntity(PaymentMethodEntity paymentMethod)
    {
        return new PaymentMethodEntity(paymentMethod.getCode(), paymentMethod.getName());
    }

    private UserEntity assembleUserEntity(UserEntity user)
    {
        return new UserEntity(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRoleEntity(user.getUserRole()), assembleVehicleEntity(user.getVehicle()));
    }

    private UserRoleEntity assembleUserRoleEntity(UserRoleEntity userRole)
    {
        return new UserRoleEntity(userRole.getCode(), userRole.getName());
    }

    private VehicleEntity assembleVehicleEntity(VehicleEntity vehicle)
    {
        return new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleEntity(vehicle.getTypeVehicle()));
    }

    private TypeVehicleEntity assembleTypeVehicleEntity(TypeVehicleEntity typeVehicle)
    {
        return new TypeVehicleEntity(typeVehicle.getCode(), typeVehicle.getName());
    }

    private ReservationEntity assembleReservationEntity(int code, Reservation reservation)
    {
        return new ReservationEntity(code, reservation.getDate(), reservation.getArrivalTime(), reservation.getDepartureTime(), assembleReservedTimeEntity(reservation.getReservedTime()), assemblePrice(reservation.getPrice()), assemblePlace(reservation.getPlace()), assemblePaymentMethod(reservation.getPaymentMethod()), assembleUser(reservation.getUser()));
    }

    private PriceEntity assemblePrice(Price price)
    {
        return new PriceEntity(price.getCode(), price.getValue());
    }

    private PlaceEntity assemblePlace(Place place)
    {
        return new PlaceEntity(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlaceEntity assembleTypePlace(TypePlace typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }

    private PaymentMethodEntity assemblePaymentMethod(PaymentMethod paymentMethod)
    {
        return new PaymentMethodEntity(paymentMethod.getCode(), paymentMethod.getName());
    }

    private UserEntity assembleUser(User user)
    {
        return new UserEntity(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRole(user.getUserRole()), assembleVehicle(user.getVehicle()));
    }

    private UserRoleEntity assembleUserRole(UserRole userRole)
    {
        return new UserRoleEntity(userRole.getCode(), userRole.getName());
    }

    private VehicleEntity assembleVehicle(Vehicle vehicle)
    {
        return new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicleEntity assembleTypeVehicle(TypeVehicle typeVehicle)
    {
        return new TypeVehicleEntity(typeVehicle.getCode(), typeVehicle.getName());
    }
}