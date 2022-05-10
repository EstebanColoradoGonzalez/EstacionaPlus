package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.UserRole;

public interface UserRoleRepository
{
    UserRole getByCode(int code);
    void save(UserRole userRole);
    void modify(int code, UserRole userRole);
    void delete(int code);
    boolean exists(UserRole userRole);
}