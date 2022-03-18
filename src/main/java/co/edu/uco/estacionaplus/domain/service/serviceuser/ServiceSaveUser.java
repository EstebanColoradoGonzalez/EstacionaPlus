package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.port.TypeVehicleRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveUser
{
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final TypeVehicleRepository typeVehicleRepository;

    public ServiceSaveUser(UserRepository userRepository, UserRoleRepository userRoleRepository, TypeVehicleRepository typeVehicleRepository)
    {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.typeVehicleRepository = typeVehicleRepository;
    }

    public void save(User user)
    {
        checkUserRoleDoesNotExists(user.getUserRole());
        checkUserDoesNotExistsWithEmail(user);
        checkUserDoesNotExistsWithIdentificationNumber(user);
        checkTypeVehicleDoesNotExists(user.getVehicle().getTypeVehicle());
        this.userRepository.save(user);
    }

    private void checkUserDoesNotExistsWithEmail(User user)
    {
        var userSummary = this.userRepository.getByEmail(user.getEmail());

        if(!UtilObject.isNull(userSummary))
        {
            throw new IllegalArgumentException("There is already someone with this email.");
        }
    }

    private void checkUserDoesNotExistsWithIdentificationNumber(User user)
    {
        var userSummary = this.userRepository.getByIdentificationNumber(user.getIdentificationNumber());

        if(!UtilObject.isNull(userSummary))
        {
            throw new IllegalArgumentException("There is already someone with this identification number.");
        }
    }

    private void checkUserRoleDoesNotExists(UserRole userRole)
    {
        if(!this.userRoleRepository.exists(userRole))
        {
            throw new IllegalArgumentException("This user role doesn't exists with this name.");
        }
    }

    private void checkTypeVehicleDoesNotExists(TypeVehicle typeVehicle)
    {
        if(!this.typeVehicleRepository.exists(typeVehicle))
        {
            throw new IllegalArgumentException("This type of vehicle doesn't exists with this name.");
        }
    }
}