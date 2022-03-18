package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Place;

import java.util.List;

public interface PlaceRepository
{
    List<Place> getAll();
    Place getByCode(int code);
    void save(Place place);
    void modify(int code, Place place);
    void delete(int code);
    boolean exists(Place place);
}