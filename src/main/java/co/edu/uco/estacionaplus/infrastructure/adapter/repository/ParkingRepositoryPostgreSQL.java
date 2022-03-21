package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.*;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.*;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.CityDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ParkingDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ParkingRepositoryPostgreSQL implements ParkingRepository
{
    private final ParkingDAO parkingDAO;
    private final CityDAO cityDAO;

    public ParkingRepositoryPostgreSQL(ParkingDAO parkingDAO, CityDAO cityDAO)
    {
        this.parkingDAO = parkingDAO;
        this.cityDAO = cityDAO;
    }

    @Override
    public List<Parking> getAll()
    {
        return this.parkingDAO.findAll().stream().map(this::assembleParking).toList();
    }

    @Override
    public Parking getByCode(int code)
    {
        return this.parkingDAO.findById(code).map(this::assembleParking).orElse(null);
    }

    @Override
    public Parking getByNIT(String nit)
    {
        var parking = this.parkingDAO.findByNit(nit);

        if(UtilObject.isNull(parking))
        {
            return null;
        }

        return assembleParking(parking);
    }

    @Override
    public Parking getByAddress(String address)
    {
        var parking = this.parkingDAO.findByAddress(address);

        if(UtilObject.isNull(parking))
        {
            return null;
        }

        return assembleParking(parking);
    }

    @Override
    public void save(Parking parking)
    {
        var city = this.cityDAO.findById(parking.getCity().getCode()).map(this::assembleCityEntity).orElse(null);

        this.parkingDAO.save(assembleParkingEntity(parking, city));
    }

    @Override
    public void modify(int code, Parking parking)
    {
        this.parkingDAO.save(assembleParkingEntity(code, parking));
    }

    @Override
    public void delete(int code)
    {
        this.parkingDAO.deleteById(code);
    }

    @Override
    public boolean exists(Parking parking)
    {
        return this.parkingDAO.existsById(parking.getCode());
    }

    private Parking assembleParking(ParkingEntity parking)
    {
        return Parking.create(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), assembleCity(parking.getCity()), assemblePlaces(parking.getPlaces()));
    }

    private City assembleCity(CityEntity city)
    {
        return City.create(city.getCode(), city.getName(), assembleState(city.getState()));
    }

    private State assembleState(StateEntity state)
    {
        return State.create(state.getCode(), state.getName());
    }

    private List<Place> assemblePlaces(List<PlaceEntity> places)
    {
        return places.stream().map(this::assemblePlace).toList();
    }

    private Place assemblePlace(PlaceEntity place)
    {
        return Place.create(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlace(place.getTypePlace()));
    }

    private TypePlace assembleTypePlace(TypePlaceEntity typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }

    private ParkingEntity assembleParkingEntity(Parking parking, CityEntity city)
    {
        return new ParkingEntity(parking.getCode(), parking.getNit(), parking.getName(), parking.getAddress(), city, assemblePlacesEntity(parking.getPlaces()));
    }

    private ParkingEntity assembleParkingEntity(int code, Parking parking)
    {
        return new ParkingEntity(code, parking.getNit(), parking.getName(), parking.getAddress(), assembleCityEntity(parking.getCity()), assemblePlacesEntity(parking.getPlaces()));
    }

    private CityEntity assembleCityEntity(City city)
    {
        return new CityEntity(city.getCode(), city.getName(), assembleStateEntity(city.getState()));
    }

    private StateEntity assembleStateEntity(State state)
    {
        return new StateEntity(state.getCode(), state.getName());
    }

    private CityEntity assembleCityEntity(CityEntity city)
    {
        return new CityEntity(city.getCode(), city.getName(), assembleStateEntity(city.getState()));
    }

    private StateEntity assembleStateEntity(StateEntity state)
    {
        return new StateEntity(state.getCode(), state.getName());
    }

    private List<PlaceEntity> assemblePlacesEntity(List<Place> places)
    {
        return places.stream().map(this::assemblePlaceEntity).toList();
    }

    private PlaceEntity assemblePlaceEntity(Place place)
    {
        return new PlaceEntity(place.getCode(), place.getPosition(), place.isTaken(), assembleTypePlaceEntity(place.getTypePlace()));
    }

    private TypePlaceEntity assembleTypePlaceEntity(TypePlace typePlace)
    {
        return new TypePlaceEntity(typePlace.getCode(), typePlace.getName());
    }
}