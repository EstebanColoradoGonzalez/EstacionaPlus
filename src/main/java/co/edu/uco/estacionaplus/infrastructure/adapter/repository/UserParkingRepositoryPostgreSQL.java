package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.*;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserParkingDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserParkingRepositoryPostgreSQL implements UserParkingRepository
{
    private final UserParkingDAO userParkingDAO;
    private final UserDAO userDAO;

    public UserParkingRepositoryPostgreSQL(UserParkingDAO userParkingDAO, UserDAO userDAO)
    {
        this.userParkingDAO = userParkingDAO;
        this.userDAO = userDAO;
    }

    @Override
    public UserParking getByCode(int code)
    {
        return this.userParkingDAO.findById(code).map(this::assembleUserParking).orElse(null);
    }

    @Override
    public void save(UserParking userParking)
    {
        var user = this.userDAO.findById(userParking.getUser().getCode()).map(this::assembleUserEntity).orElse(null);

        this.userParkingDAO.save(assembleUserParkingEntity(userParking, user));
    }

    @Override
    public void modify(int code, UserParking userParking)
    {
        this.userParkingDAO.save(assembleUserParkingEntity(code, userParking));
    }

    @Override
    public void delete(int code)
    {
        this.userParkingDAO.deleteById(code);
    }

    @Override
    public boolean exists(UserParking userParking)
    {
        return this.userParkingDAO.existsById(userParking.getCode());
    }

    private UserParking assembleUserParking(UserParkingEntity userParking)
    {
        return UserParking.create(userParking.getCode(), assembleUser(userParking.getUser()), assembleParking(userParking.getParking()));
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

    private Parking assembleParking(ParkingEntity parking)
    {
        return Parking.create(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), assembleCity(parking.getCity()), assemblePlaces(parking.getPlaces()));
    }

    private City assembleCity(CityEntity city)
    {
        return City.create(city.getCode(), city.getName(), assembleState(city.getState()));
    }

    private State assembleState(StateEntity state)
    {
        return State.create(state.getCode(), state.getName());
    }

    private List<Place> assemblePlaces(List<PlaceEntity> places)
    {
        return places.stream().map(this::assemblePlace).toList();
    }

    private Place assemblePlace(PlaceEntity place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceEntity typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private UserParkingEntity assembleUserParkingEntity(UserParking userParking, UserEntity user)
    {
        return new UserParkingEntity(userParking.getCode(), user, assembleParkingEntity(userParking.getParking()));
    }

    private UserParkingEntity assembleUserParkingEntity(int code, UserParking userParking)
    {
        return new UserParkingEntity(code, assembleUserEntity(userParking.getUser()), assembleParkingEntity(userParking.getParking()));
    }

    private UserEntity assembleUserEntity(User user)
    {
        return new UserEntity(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRoleEntity(user.getUserRole()), assembleVehicleEntity(user.getVehicle()));
    }

    private UserRoleEntity assembleUserRoleEntity(UserRole userRole)
    {
        return new UserRoleEntity(userRole.getCode(), userRole.getName());
    }

    private VehicleEntity assembleVehicleEntity(Vehicle vehicle)
    {
        return new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleEntity(vehicle.getTypeVehicle()));
    }

    private TypeVehicleEntity assembleTypeVehicleEntity(TypeVehicle typeVehicle)
    {
        return new TypeVehicleEntity(typeVehicle.getCode(), typeVehicle.getName());
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

    private ParkingEntity assembleParkingEntity(Parking parking)
    {
        return new ParkingEntity(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), assembleCityEntity(parking.getCity()), assemblePlacesEntity(parking.getPlaces()));
    }

    private CityEntity assembleCityEntity(City city)
    {
        return new CityEntity(city.getCode(), city.getName(), assembleStateEntity(city.getState()));
    }

    private StateEntity assembleStateEntity(State state)
    {
        return new StateEntity(state.getCode(), state.getName());
    }

    private List<PlaceEntity> assemblePlacesEntity(List<Place> places)
    {
        return places.stream().map(this::assemblePlaceEntity).toList();
    }

    private PlaceEntity assemblePlaceEntity(Place place)
    {
        return new PlaceEntity(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlaceEntity(place.getTypePlace()));
    }

    private TypePlaceEntity assembleTypePlaceEntity(TypePlace typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }
}