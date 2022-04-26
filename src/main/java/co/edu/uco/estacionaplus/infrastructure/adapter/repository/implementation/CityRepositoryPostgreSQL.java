package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.domain.port.CityRepository;
import co.edu.uco.estacionaplus.domain.validator.ValidateObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.CityDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.CityAssemblerImplementation.getCityAssembler;

@Repository
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
        return this.cityDAO.findAll().stream().map(getCityAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public City getByCode(int code)
    {
        return this.cityDAO.findById(code).map(getCityAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public City getByName(String name)
    {
        var city = this.cityDAO.findByName(name);

        if(ValidateObject.isNull(city))
        {
            return null;
        }

        return getCityAssembler().assembleDomainFromEntity(city);
    }

    @Override
    public boolean exists(City city)
    {
        return this.cityDAO.existsById(city.getCode());
    }
}