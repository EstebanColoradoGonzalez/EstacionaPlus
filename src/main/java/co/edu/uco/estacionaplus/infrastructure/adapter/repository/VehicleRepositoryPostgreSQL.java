package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.VehicleDAO;
import org.springframework.stereotype.Repository;

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
        return this.vehicleDAO.findById(code).map(this::assembleVehicle).orElse(null);
    }

    @Override
    public Vehicle getByLicense(String license)
    {
        var vehicle = this.vehicleDAO.findByLicense(license);

        if(UtilObject.isNull(vehicle))
        {
            return null;
        }

        return assembleVehicle(vehicle);
    }

    @Override
    public void save(Vehicle vehicle)
    {
        var typeVehicle = this.typeVehicleDAO.findById(vehicle.getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.vehicleDAO.save(assembleVehicleEntity(vehicle, typeVehicle));
    }

    @Override
    public boolean exists(Vehicle vehicle)
    {
        return this.vehicleDAO.existsById(vehicle.getCode());
    }

    private Vehicle assembleVehicle(VehicleEntity vehicle)
    {
        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), assembleTypeVehicle(vehicle.getTypeVehicle()));
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicleEntity typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }

    private VehicleEntity assembleVehicleEntity(Vehicle vehicle, TypeVehicleEntity typeVehicle)
    {
        return new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), typeVehicle);
    }
}