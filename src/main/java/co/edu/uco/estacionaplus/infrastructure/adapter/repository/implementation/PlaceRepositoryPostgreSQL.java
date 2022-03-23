package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypePlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypePlaceDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.TypePlaceAssemblerImplementation.getTypePlaceAssembler;

@Repository
public class PlaceRepositoryPostgreSQL implements PlaceRepository
{
    private final PlaceDAO placeDAO;
    private final TypePlaceDAO typePlaceDAO;

    public PlaceRepositoryPostgreSQL(PlaceDAO placeDAO, TypePlaceDAO typePlaceDAO)
    {
        this.placeDAO = placeDAO;
        this.typePlaceDAO = typePlaceDAO;
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

        if(UtilObject.isNull(place))
        {
            return null;
        }

        return getPlaceAssembler().assembleDomainFromEntity(place);
    }

    @Override
    public void save(Place place)
    {
        var typePlace = this.typePlaceDAO.findById(place.getCode()).map(getTypePlaceAssembler()::assembleDomainFromEntity).orElse(null);


        this.placeDAO.save(getPlaceAssembler().assembleEntityFromDomainToSave(place, typePlace));
    }

    @Override
    public void modify(int code, Place place)
    {
        this.placeDAO.save(getPlaceAssembler().assembleEntityFromDomainToModify(code, place));
    }

    @Override
    public void delete(int code)
    {
        this.placeDAO.deleteById(code);
    }

    @Override
    public boolean exists(Place place)
    {
        return this.placeDAO.existsById(place.getCode());
    }
}