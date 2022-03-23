package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.VehicleDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.VehicleAssemblerImplementation.getVehicleAssembler;

@Repository
public class VehicleRepositoryPostgreSQL implements VehicleRepository
{
    private final VehicleDAO vehicleDAO;
    private final TypeVehicleDAO typeVehicleDAO;

    public VehicleRepositoryPostgreSQL(VehicleDAO vehicleDAO, TypeVehicleDAO typeVehicleDAO)
    {
        this.vehicleDAO = vehicleDAO;
        this.typeVehicleDAO = typeVehicleDAO;
    }

    @Override
    public Vehicle getByCode(int code)
    {
        return this.vehicleDAO.findById(code).map(getVehicleAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public Vehicle getByLicense(String license)
    {
        var vehicle = this.vehicleDAO.findByLicense(license);

        if(UtilObject.isNull(vehicle))
        {
            return null;
        }

        return getVehicleAssembler().assembleDomainFromEntity(vehicle);
    }

    @Override
    public void save(Vehicle vehicle)
    {
        var typeVehicle = this.typeVehicleDAO.findById(vehicle.getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.vehicleDAO.save(getVehicleAssembler().assembleEntityFromDomainToSave(vehicle, typeVehicle));
    }

    @Override
    public boolean exists(Vehicle vehicle)
    {
        return this.vehicleDAO.existsById(vehicle.getCode());
    }
}