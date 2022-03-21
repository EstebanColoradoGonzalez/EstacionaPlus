package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.domain.model.State;
import co.edu.uco.estacionaplus.domain.port.CityRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.CityEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.StateEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.CityDAO;
import java.util.List;

public class CityRepositoryPostgreSQL implements CityRepository
{
    private final CityDAO cityDAO;

    public CityRepositoryPostgreSQL(CityDAO cityDAO)
    {
        this.cityDAO = cityDAO;
    }

    @Override
    public List<City> getAll()
    {
        return this.cityDAO.findAll().stream().map(this::assembleCity).toList();
    }

    @Override
    public City getByCode(int code)
    {
        return this.cityDAO.findById(code).map(this::assembleCity).orElse(null);
    }

    @Override
    public City getByName(String name)
    {
        var city = this.cityDAO.findByName(name);

        if(UtilObject.isNull(city))
        {
            return null;
        }

        return assembleCity(city);
    }

    @Override
    public boolean exists(City city)
    {
        return this.cityDAO.existsById(city.getCode());
    }

    private City assembleCity(CityEntity city)
    {
        return City.create(city.getCode(), city.getName(), assembleState(city.getState()));
    }

    private State assembleState(StateEntity state)
    {
        return State.create(state.getCode(), state.getName());
    }
}