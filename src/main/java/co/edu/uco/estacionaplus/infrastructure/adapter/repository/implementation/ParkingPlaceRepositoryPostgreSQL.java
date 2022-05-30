package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.ParkingPlace;
import co.edu.uco.estacionaplus.domain.port.ParkingPlaceRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ParkingPlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingPlaceAssemblerImplementation.getParkingPlaceAssembler;

@Repository
public class ParkingPlaceRepositoryPostgreSQL implements ParkingPlaceRepository
{
    private final ParkingPlaceDAO parkingPlaceDAO;
    private final PlaceDAO placeDAO;

    public ParkingPlaceRepositoryPostgreSQL(ParkingPlaceDAO parkingPlaceDAO, PlaceDAO placeDAO)
    {
        this.parkingPlaceDAO = parkingPlaceDAO;
        this.placeDAO = placeDAO;
    }

    @Override
    public ParkingPlace getByCode(int code)
    {
        return this.parkingPlaceDAO.findById(code).map(getParkingPlaceAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(ParkingPlace parkingPlace)
    {
        var place = this.placeDAO.findById(parkingPlace.getPlace().getCode()).orElse(null);

        this.parkingPlaceDAO.save(getParkingPlaceAssembler().assembleEntityFromDomainToSave(parkingPlace, place));
    }

    @Override
    public void modify(int code, ParkingPlace parkingPlace)
    {
        this.parkingPlaceDAO.save(getParkingPlaceAssembler().assembleEntityFromDomainToModify(code, parkingPlace));
    }

    @Override
    public void delete(int code)
    {
        this.parkingPlaceDAO.deleteById(code);
    }

    @Override
    public boolean exists(ParkingPlace parkingPlace)
    {
        return this.parkingPlaceDAO.existsById(parkingPlace.getCode());
    }
}