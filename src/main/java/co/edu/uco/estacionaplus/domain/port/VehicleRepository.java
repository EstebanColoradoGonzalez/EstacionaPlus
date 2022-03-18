package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Vehicle;

public interface VehicleRepository
{
    Vehicle getByCode(int code);
    Vehicle getByLicense(String License);
    void save(Vehicle vehicle);
    boolean exists(Vehicle vehicle);
}