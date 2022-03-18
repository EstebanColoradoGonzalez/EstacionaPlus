package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.ReservedTime;

public interface ReservedTimeRepository
{
    ReservedTime getByCode(int code);
    void save(ReservedTime reservedTime);
    boolean exists(ReservedTime reservedTime);
}