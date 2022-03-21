package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import java.util.List;

public interface TypeVehicleRepository
{
    List<TypeVehicle> getAll();
    TypeVehicle getByCode(int code);
    boolean exists(TypeVehicle typeVehicle);
}