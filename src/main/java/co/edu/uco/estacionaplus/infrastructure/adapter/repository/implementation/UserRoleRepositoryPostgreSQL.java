package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.RoleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserRoleDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserRoleAssemblerImplementation.getUserRoleAssembler;

@Repository
public class UserRoleRepositoryPostgreSQL implements UserRoleRepository
{
    private final UserRoleDAO userRoleDAO;
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public UserRoleRepositoryPostgreSQL(UserRoleDAO userRoleDAO, UserDAO userDAO, RoleDAO roleDAO)
    {
        this.userRoleDAO = userRoleDAO;
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public UserRole getByCode(int code)
    {
        return this.userRoleDAO.findById(code).map(getUserRoleAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(UserRole userRole)
    {
        var role = this.roleDAO.findById(userRole.getCode()).orElse(null);
        var userRoles = this.userRoleDAO.findAll();
        var lastIndex = 1;

        if(!userRoles.isEmpty())
        {
            lastIndex = userRoles.get(userRoles.size() - 1).getCode() + 1;
        }

        this.userRoleDAO.save(getUserRoleAssembler().assembleEntityFromDomainToSave(lastIndex, role));
    }

    @Override
    public void modify(int code, UserRole userRole)
    {
        var userRoleEntity = getUserRoleAssembler().assembleEntityFromDomain(userRole);

        userRoleEntity.setCode(code);

        this.userRoleDAO.save(userRoleEntity);
    }

    @Override
    public void delete(int code)
    {
        this.userRoleDAO.deleteById(code);
    }

    @Override
    public boolean exists(UserRole userRole)
    {
        return this.userRoleDAO.existsById(userRole.getCode());
    }
}