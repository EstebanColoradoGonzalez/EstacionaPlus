package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.UserParking;

public interface UserParkingRepository
{
    UserParking getByCode(int code);
    void save(UserParking userParking);
    void modify(int code, UserParking userParking);
    void delete(int code);
    boolean exists(UserParking userParking);
}