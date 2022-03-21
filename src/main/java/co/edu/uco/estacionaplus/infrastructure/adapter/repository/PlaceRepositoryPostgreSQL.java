package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypePlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypePlaceDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

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
        return this.placeDAO.findAll().stream().map(this::assemblePlace).toList();
    }

    @Override
    public Place getByCode(int code)
    {
        return this.placeDAO.findById(code).map(this::assemblePlace).orElse(null);
    }

    @Override
    public void save(Place place)
    {
        var typePlace = this.typePlaceDAO.findById(place.getCode()).map(this::assembleTypePlaceEntity).orElse(null);

        this.placeDAO.save(assemblePlaceEntity(place, typePlace));
    }

    @Override
    public void modify(int code, Place place)
    {
        this.placeDAO.save(assemblePlaceEntity(code, place));
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

    private Place assemblePlace(PlaceEntity place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceEntity typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private PlaceEntity assemblePlaceEntity(int code, Place place)
    {
        return new PlaceEntity(code, place.getPosition(), place.isTaken(), assembleTypePlaceEntity(place.getTypePlace()));
    }

    private PlaceEntity assemblePlaceEntity(Place place, TypePlaceEntity typePlace)
    {
        return new PlaceEntity(place.getCode(), place.getPosition(), place.isTaken(), typePlace);
    }

    private TypePlaceEntity assembleTypePlaceEntity(TypePlace typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }

    private TypePlaceEntity assembleTypePlaceEntity(TypePlaceEntity typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }
}