package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Parking;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.CityDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ParkingDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

import static co.edu.uco.estacionaplus.domain.assembler.implementation.CityAssemblerImplementation.getCityAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingAssemblerImplementation.getParkingAssembler;

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
        return this.parkingDAO.findAll().stream().map(getParkingAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public Parking getByCode(int code)
    {
        return this.parkingDAO.findById(code).map(getParkingAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public Parking getByNIT(String nit)
    {
        var parking = this.parkingDAO.findByNit(nit);

        if(UtilObject.isNull(parking))
        {
            return null;
        }

        return getParkingAssembler().assembleDomainFromEntity(parking);
    }

    @Override
    public Parking getByAddress(String address)
    {
        var parking = this.parkingDAO.findByAddress(address);

        if(UtilObject.isNull(parking))
        {
            return null;
        }

        return getParkingAssembler().assembleDomainFromEntity(parking);
    }

    @Override
    public void save(Parking parking)
    {
        var city = this.cityDAO.findById(parking.getCity().getCode()).map(getCityAssembler()::assembleDomainFromEntity).orElse(null);

        this.parkingDAO.save(getParkingAssembler().assembleEntityFromDomainToSave(parking, city));
    }

    @Override
    public void modify(int code, Parking parking)
    {
        this.parkingDAO.save(getParkingAssembler().assembleEntityFromDomainToModify(code, parking));
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
}