package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.application.dto.*;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceGetUserParkingByCode;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ServiceApplicationGetUserParkingByCode
{
    private final ServiceGetUserParkingByCode serviceGetUserParkingByCode;

    public ServiceApplicationGetUserParkingByCode(ServiceGetUserParkingByCode serviceGetUserParkingByCode)
    {
        this.serviceGetUserParkingByCode = serviceGetUserParkingByCode;
    }

    public UserParkingDTO getByCode(int code)
    {
        return assembleUserParkingDTO(this.serviceGetUserParkingByCode.getByCode(code));
    }

    private UserParkingDTO assembleUserParkingDTO(UserParking userParking)
    {
        return new UserParkingDTO(userParking.getCode(), assembleUserDTO(userParking.getUser()), assembleParkingDTO(userParking.getParking()));
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

    private ParkingDTO assembleParkingDTO(Parking parking)
    {
        return new ParkingDTO(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), assembleCityDTO(parking.getCity()), assemblePlacesDTO(parking.getPlaces()));
    }

    private CityDTO assembleCityDTO(City city)
    {
        return new CityDTO(city.getCode(), city.getName(), assembleStateDTO(city.getState()));
    }

    private StateDTO assembleStateDTO(State state)
    {
        return new StateDTO(state.getCode(), state.getName());
    }

    private List<PlaceDTO> assemblePlacesDTO(List<Place> places)
    {
        return places.stream().map(this::assemblePlaceDTO).toList();
    }

    private PlaceDTO assemblePlaceDTO(Place place)
    {
        return new PlaceDTO(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlaceDTO(place.getTypePlace()));
    }

    private TypePlaceDTO assembleTypePlaceDTO(TypePlace typePlace)
    {
        return new TypePlaceDTO(typePlace.getCode(), typePlace.getName());
    }
}