package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserRoleDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryPostgreSQL implements UserRepository
{
    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;
    private final TypeVehicleDAO typeVehicleDAO;

    public UserRepositoryPostgreSQL(UserDAO userDAO, UserRoleDAO userRoleDAO, TypeVehicleDAO typeVehicleDAO)
    {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
        this.typeVehicleDAO = typeVehicleDAO;
    }

    @Override
    public List<UserSummaryDTO> getAll()
    {
        return this.userDAO.findAll().stream().map(this::assembleUserSummaryDTO).toList();
    }

    @Override
    public UserSummaryDTO getByCode(int code)
    {
        return this.userDAO.findById(code).map(this::assembleUserSummaryDTO).orElse(null);
    }

    @Override
    public UserSummaryDTO getByIdentificationNumber(String identificationNumber)
    {
        var user = this.userDAO.findByIdentificationNumber(identificationNumber);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return assembleUserSummaryDTO(user);
    }

    @Override
    public UserSummaryDTO getByEmail(String email)
    {
        var user = this.userDAO.findByEmail(email);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return assembleUserSummaryDTO(user);
    }

    @Override
    public void save(User user)
    {
        var userRole = this.userRoleDAO.findById(user.getUserRole().getCode()).map(entity -> new UserRoleEntity(entity.getCode(), entity.getName())).orElse(null);
        var typeVehicle = this.typeVehicleDAO.findById(user.getVehicle().getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.userDAO.save(assembleUserEntity(user, userRole, typeVehicle));
    }

    @Override
    public void modify(int code, User user)
    {
        this.userDAO.save(assembleUserEntity(code, user));
    }

    @Override
    public void delete(int code)
    {
        this.userDAO.deleteById(code);
    }

    @Override
    public boolean exists(UserSummaryDTO user)
    {
        return this.userDAO.existsById(user.getCode());
    }

    private UserEntity assembleUserEntity(User user, UserRoleEntity userRole, TypeVehicleEntity typeVehicle)
    {
        return new UserEntity(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRoleEntity(userRole), assembleVehicleEntity(user.getVehicle(), typeVehicle));
    }

    private UserRoleEntity assembleUserRoleEntity(UserRoleEntity userRole)
    {
        return new UserRoleEntity(userRole.getCode(), userRole.getName());
    }

    private VehicleEntity assembleVehicleEntity(Vehicle vehicle, TypeVehicleEntity typeVehicle)
    {
        return new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleEntity(typeVehicle));
    }

    private TypeVehicleEntity assembleTypeVehicleEntity(TypeVehicleEntity typeVehicle)
    {
        return new TypeVehicleEntity(typeVehicle.getCode(), typeVehicle.getName());
    }

    private UserEntity assembleUserEntity(int code, User user)
    {
        return new UserEntity(code, user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), assembleUserRoleEntity(user.getUserRole()), assembleVehicleEntity(user.getVehicle()));
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

    private UserSummaryDTO assembleUserSummaryDTO(UserEntity user)
    {
        return new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), assembleUserRoleSummaryDTO(user.getUserRole()), assembleVehicleSummaryDTO(user.getVehicle()));
    }

    private UserRoleSummaryDTO assembleUserRoleSummaryDTO(UserRoleEntity userRole)
    {
        return new UserRoleSummaryDTO(userRole.getCode(), userRole.getName());
    }

    private VehicleSummaryDTO assembleVehicleSummaryDTO(VehicleEntity vehicle)
    {
        return new VehicleSummaryDTO(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicleSummaryDTO(vehicle.getTypeVehicle()));
    }

    private TypeVehicleSummaryDTO assembleTypeVehicleSummaryDTO(TypeVehicleEntity typeVehicle)
    {
        return new TypeVehicleSummaryDTO(typeVehicle.getCode(), typeVehicle.getName());
    }
}