package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.ParkingPlace;

public interface ParkingPlaceRepository
{
    ParkingPlace getByCode(int code);
    void save(ParkingPlace parkingPlace);
    void modify(int code, ParkingPlace parkingPlace);
    void delete(int code);
    boolean exists(ParkingPlace parkingPlace);
}