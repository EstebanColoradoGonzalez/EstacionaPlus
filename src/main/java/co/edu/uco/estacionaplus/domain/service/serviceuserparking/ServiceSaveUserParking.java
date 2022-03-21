package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveUserParking
{
    private static final String MESSAGE_USER_DOES_NOT_EXISTS = "This user doesn't exists";
    private static final String MESSAGE_EXISTS_WITH_NIT = "There is already some parking with this NIT.";
    private static final String MESSAGE_EXISTS_WITH_ADDRESS = "There is already some parking located in this address.";

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
        this.userParkingRepository.save(userParking);
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(assembleUserSummaryDTO(user)))
        {
            throw new IllegalArgumentException(MESSAGE_USER_DOES_NOT_EXISTS);
        }
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
            throw new IllegalArgumentException(MESSAGE_EXISTS_WITH_NIT);
        }
    }

    private void checkParkingDoesNotExistsWithAddress(String address)
    {
        var parking = this.parkingRepository.getByAddress(address);

        if(!UtilObject.isNull(parking))
        {
            throw new IllegalArgumentException(MESSAGE_EXISTS_WITH_ADDRESS);
        }
    }
}