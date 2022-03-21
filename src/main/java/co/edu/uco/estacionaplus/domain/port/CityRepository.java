package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.City;
import java.util.List;

public interface CityRepository
{
    List<City> getAll();
    City getByCode(int code);
    City getByName(String name);
    boolean exists(City city);
}