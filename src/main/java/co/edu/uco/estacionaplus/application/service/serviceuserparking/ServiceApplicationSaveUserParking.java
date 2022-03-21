package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.application.dto.*;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceSaveUserParking;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ServiceApplicationSaveUserParking
{
    private final ServiceSaveUserParking serviceSaveUserParking;

    public ServiceApplicationSaveUserParking(ServiceSaveUserParking serviceSaveUserParking)
    {
        this.serviceSaveUserParking = serviceSaveUserParking;
    }

    public void save(UserParkingDTO userParking)
    {
        this.serviceSaveUserParking.save(assembleUserParking(userParking));
    }

    private UserParking assembleUserParking(UserParkingDTO userParking)
    {
        return UserParking.create(userParking.getCode(), assembleUser(userParking.getUser()), assembleParking(userParking.getParking()));
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

    private Parking assembleParking(ParkingDTO parking)
    {
        return Parking.create(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), assembleCity(parking.getCity()), assemblePlaces(parking.getPlaces()));
    }

    private City assembleCity(CityDTO city)
    {
        return City.create(city.getCode(), city.getName(), assembleState(city.getState()));
    }

    private State assembleState(StateDTO state)
    {
        return State.create(state.getCode(), state.getName());
    }

    private List<Place> assemblePlaces(List<PlaceDTO> places)
    {
        return places.stream().map(this::assemblePlace).toList();
    }

    private Place assemblePlace(PlaceDTO place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceDTO typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }
}