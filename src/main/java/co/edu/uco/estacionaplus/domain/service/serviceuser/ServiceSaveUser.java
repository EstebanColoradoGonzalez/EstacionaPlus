package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.TypeVehicleRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveUser
{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final VehicleRepository vehicleRepository;
    private final TypeVehicleRepository typeVehicleRepository;

    public ServiceSaveUser(UserRepository userRepository, UserRoleRepository userRoleRepository, VehicleRepository vehicleRepository, TypeVehicleRepository typeVehicleRepository)
    {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.vehicleRepository = vehicleRepository;
        this.typeVehicleRepository = typeVehicleRepository;
    }

    public void save(User user)
    {
        checkUserRoleDoesNotExists(user.getUserRole());
        checkUserDoesNotExistsWithEmail(user);
        checkUserDoesNotExistsWithIdentificationNumber(user);
        checkTypeVehicleDoesNotExists(user.getVehicle().getTypeVehicle());
        checkVehicleDoesNotExistsWithLicense(user.getVehicle());
        this.userRepository.save(user);
    }

    private void checkUserRoleDoesNotExists(UserRole userRole)
    {
        if(!this.userRoleRepository.exists(userRole))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_USER_ROLE_DOES_NOT_EXISTS_WITH_NAME);
        }
    }

    private void checkUserDoesNotExistsWithEmail(User user)
    {
        var userSummary = this.userRepository.getByEmail(user.getEmail());

        if(!UtilObject.isNull(userSummary))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_EMAIL);
        }
    }

    private void checkUserDoesNotExistsWithIdentificationNumber(User user)
    {
        var userSummary = this.userRepository.getByIdentificationNumber(user.getIdentificationNumber());

        if(!UtilObject.isNull(userSummary))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_IDENTIFICATION_NUMBER);
        }
    }

    private void checkTypeVehicleDoesNotExists(TypeVehicle typeVehicle)
    {
        if(!this.typeVehicleRepository.exists(typeVehicle))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_TYPE_VEHICLE_DOES_NOT_EXISTS_WITH_NAME);
        }
    }

    private void checkVehicleDoesNotExistsWithLicense(Vehicle vehicle)
    {
        var vehicleSummary = this.vehicleRepository.getByLicense(vehicle.getLicense());

        if(!UtilObject.isNull(vehicleSummary))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_VEHICLE_EXISTS_WITH_LICENSE);
        }
    }
}