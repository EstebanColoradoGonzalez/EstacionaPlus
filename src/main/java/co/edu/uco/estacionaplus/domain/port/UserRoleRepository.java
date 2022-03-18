package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.UserRole;

public interface UserRoleRepository
{
    UserRole getByCode(int code);
    boolean exists(UserRole uerRole);
}