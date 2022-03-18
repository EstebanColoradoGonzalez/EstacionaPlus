package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserRoleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.VehicleDAO;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

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
        return this.userDAO.findAll().stream().map(entity -> new UserSummaryDTO(entity.getCode(), entity.getNames(), entity.getLastNames(), entity.getIdentificationNumber(), entity.getPhone(), entity.getEmail(), new UserRoleSummaryDTO(entity.getUserRole().getCode(), entity.getUserRole().getName()), new VehicleSummaryDTO(entity.getVehicle().getCode(), entity.getVehicle().getLicense(), new TypeVehicleSummaryDTO(entity.getVehicle().getTypeVehicle().getCode(), entity.getVehicle().getTypeVehicle().getName())))).collect(Collectors.toList());
    }

    @Override
    public UserSummaryDTO getByCode(int code)
    {
        return this.userDAO.findById(code).map(entity -> new UserSummaryDTO(entity.getCode(), entity.getNames(), entity.getLastNames(), entity.getIdentificationNumber(), entity.getPhone(), entity.getEmail(), new UserRoleSummaryDTO(entity.getUserRole().getCode(), entity.getUserRole().getName()), new VehicleSummaryDTO(entity.getVehicle().getCode(), entity.getVehicle().getLicense(), new TypeVehicleSummaryDTO(entity.getVehicle().getTypeVehicle().getCode(), entity.getVehicle().getTypeVehicle().getName())))).orElse(null);
    }

    @Override
    public UserSummaryDTO getByIdentificationNumber(String identificationNumber)
    {
        UserEntity user = this.userDAO.findByIdentificationNumber(identificationNumber);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), new UserRoleSummaryDTO(user.getUserRole().getCode(), user.getUserRole().getName()), new VehicleSummaryDTO(user.getVehicle().getCode(), user.getVehicle().getLicense(), new TypeVehicleSummaryDTO(user.getVehicle().getTypeVehicle().getCode(), user.getVehicle().getTypeVehicle().getName())));
    }

    @Override
    public UserSummaryDTO getByEmail(String email)
    {
        UserEntity user = this.userDAO.findByEmail(email);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), new UserRoleSummaryDTO(user.getUserRole().getCode(), user.getUserRole().getName()), new VehicleSummaryDTO(user.getVehicle().getCode(), user.getVehicle().getLicense(), new TypeVehicleSummaryDTO(user.getVehicle().getTypeVehicle().getCode(), user.getVehicle().getTypeVehicle().getName())));
    }

    @Override
    public void save(User user)
    {
        var userRole = this.userRoleDAO.findById(user.getUserRole().getCode()).map(entity -> new UserRoleEntity(entity.getCode(), entity.getName())).orElse(null);
        var typeVehicle = this.typeVehicleDAO.findById(user.getVehicle().getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.userDAO.save(new UserEntity(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), userRole, new VehicleEntity(user.getVehicle().getCode(), user.getVehicle().getLicense(), typeVehicle)));
    }

    @Override
    public void modify(int code, User user)
    {
        this.userDAO.save(new UserEntity(code, user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), user.getPassword(), new UserRoleEntity(user.getUserRole().getCode(), user.getUserRole().getName()), new VehicleEntity(user.getVehicle().getCode(), user.getVehicle().getLicense(), new TypeVehicleEntity(user.getVehicle().getTypeVehicle().getCode(), user.getVehicle().getTypeVehicle().getName()))));
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
}