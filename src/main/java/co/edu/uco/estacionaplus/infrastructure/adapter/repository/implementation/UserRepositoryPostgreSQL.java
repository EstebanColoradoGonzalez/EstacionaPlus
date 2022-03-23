package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserRoleDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

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
        return this.userDAO.findAll().stream().map(getUserAssembler()::assembleSummaryDTOFromEntity).toList();
    }

    @Override
    public UserSummaryDTO getByCode(int code)
    {
        return this.userDAO.findById(code).map(getUserAssembler()::assembleSummaryDTOFromEntity).orElse(null);
    }

    @Override
    public UserSummaryDTO getByIdentificationNumber(String identificationNumber)
    {
        var user = this.userDAO.findByIdentificationNumber(identificationNumber);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return getUserAssembler().assembleSummaryDTOFromEntity(user);
    }

    @Override
    public UserSummaryDTO getByEmail(String email)
    {
        var user = this.userDAO.findByEmail(email);

        if(UtilObject.isNull(user))
        {
            return null;
        }

        return getUserAssembler().assembleSummaryDTOFromEntity(user);
    }

    @Override
    public void save(User user)
    {
        var userRole = this.userRoleDAO.findById(user.getUserRole().getCode()).map(entity -> new UserRoleEntity(entity.getCode(), entity.getName())).orElse(null);
        var typeVehicle = this.typeVehicleDAO.findById(user.getVehicle().getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.userDAO.save(getUserAssembler().assembleEntityFromDomainToSave(user, userRole, typeVehicle));
    }

    @Override
    public void modify(int code, User user)
    {
        this.userDAO.save(getUserAssembler().assembleEntityFromDomainToModify(code, user));
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