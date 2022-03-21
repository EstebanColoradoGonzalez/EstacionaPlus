package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.TypePlace;
import java.util.List;

public interface TypePlaceRepository
{
    List<TypePlace> getAll();
    TypePlace getByCode(int code);
    boolean exists(TypePlace typePlace);
}