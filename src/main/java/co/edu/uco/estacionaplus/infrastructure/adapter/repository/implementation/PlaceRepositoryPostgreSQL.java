package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.validator.ValidateObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;

@Repository
public class PlaceRepositoryPostgreSQL implements PlaceRepository
{
    private final PlaceDAO placeDAO;

    public PlaceRepositoryPostgreSQL(PlaceDAO placeDAO)
    {
        this.placeDAO = placeDAO;
    }

    @Override
    public List<Place> getAll()
    {
        return this.placeDAO.findAll().stream().map(getPlaceAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public Place getByCode(int code)
    {
        return this.placeDAO.findById(code).map(getPlaceAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public Place getByPosition(String position)
    {
        var place = this.placeDAO.findByPosition(position);

        if(ValidateObject.isNull(place))
        {
            return null;
        }

        return getPlaceAssembler().assembleDomainFromEntity(place);
    }

    @Override
    public boolean exists(Place place)
    {
        return this.placeDAO.existsById(place.getCode());
    }
}