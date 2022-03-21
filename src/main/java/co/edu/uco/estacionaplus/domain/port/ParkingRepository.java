package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Parking;
import java.util.List;

public interface ParkingRepository
{
    List<Parking> getAll();
    Parking getByCode(int code);
    Parking getByNIT(String nit);
    Parking getByAddress(String address);
    void save(Parking parking);
    void modify(int code, Parking parking);
    void delete(int code);
    boolean exists(Parking parking);
}