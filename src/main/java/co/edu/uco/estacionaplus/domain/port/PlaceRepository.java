package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Place;
import java.util.List;

public interface PlaceRepository
{
    List<Place> getAll();
    Place getByCode(int code);
    Place getByPosition(String position);
    boolean exists(Place place);
}