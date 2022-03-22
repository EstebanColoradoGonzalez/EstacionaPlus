package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveUserParking
{
    private final UserParkingRepository userParkingRepository;
    private final UserRepository userRepository;
    private final ParkingRepository parkingRepository;

    public ServiceSaveUserParking(UserParkingRepository userParkingRepository, UserRepository userRepository, ParkingRepository parkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
    }

    public void save(UserParking userParking)
    {
        checkUserDoesNotExists(userParking.getUser());
        checkParkingDoesNotExistsWithNIT(userParking.getParking().getNit());
        checkParkingDoesNotExistsWithAddress(userParking.getParking().getAddress());
        this.userRepository.modify(userParking.getUser().getCode(), assembleUser(userParking.getUser()));
        this.userParkingRepository.save(userParking);
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(assembleUserSummaryDTO(user)))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_USER_DOES_NOT_EXISTS);
        }
    }

    private User assembleUser(User user)
    {
        return User.create(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRole(user.getUserRole()), assembleVehicle(user.getVehicle()));
    }

    private UserRole assembleUserRole(UserRole userRole)
    {
        return UserRole.create(userRole.getCode(), "ROLE_ADMIN");
    }

    private Vehicle assembleVehicle(Vehicle vehicle)
    {
        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicle typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }

    private UserSummaryDTO assembleUserSummaryDTO(User user)
    {
        return new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), assembleUserRoleSummaryDTO(user.getUserRole()), assembleVehicleSummaryDTO(user.getVehicle()));
    }

    private UserRoleSummaryDTO assembleUserRoleSummaryDTO(UserRole userRole)
    {
        return new UserRoleSummaryDTO(userRole.getCode(), userRole.getName());
    }

    private VehicleSummaryDTO assembleVehicleSummaryDTO(Vehicle vehicle)
    {
        return new VehicleSummaryDTO(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleSummaryDTO(vehicle.getTypeVehicle()));
    }

    private TypeVehicleSummaryDTO assembleTypeVehicleSummaryDTO(TypeVehicle typeVehicle)
    {
        return new TypeVehicleSummaryDTO(typeVehicle.getCode(), typeVehicle.getName());
    }

    private void checkParkingDoesNotExistsWithNIT(String nit)
    {
        var parking = this.parkingRepository.getByNIT(nit);

        if(!UtilObject.isNull(parking))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_NIT);
        }
    }

    private void checkParkingDoesNotExistsWithAddress(String address)
    {
        var parking = this.parkingRepository.getByAddress(address);

        if(!UtilObject.isNull(parking))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_ADDRESS);
        }
    }
}