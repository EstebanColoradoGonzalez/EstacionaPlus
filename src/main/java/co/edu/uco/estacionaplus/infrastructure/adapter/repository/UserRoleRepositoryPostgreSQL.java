package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserRoleDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepositoryPostgreSQL implements UserRoleRepository
{
    private final UserRoleDAO userRoleDAO;

    public UserRoleRepositoryPostgreSQL(UserRoleDAO userRoleDAO)
    {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public UserRole getByCode(int code)
    {
        return this.userRoleDAO.findById(code).map(this::assembleUserRole).orElse(null);
    }

    @Override
    public boolean exists(UserRole uerRole)
    {
        return this.userRoleDAO.existsById(uerRole.getCode());
    }

    private UserRole assembleUserRole(UserRoleEntity userRole)
    {
        return UserRole.create(userRole.getCode(), userRole.getName());
    }
}
