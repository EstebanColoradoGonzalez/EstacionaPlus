package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
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
        return this.vehicleDAO.findById(code).map(entity -> Vehicle.create(entity.getCode(), entity.getLicense(), TypeVehicle.create(entity.getTypeVehicle().getCode(), entity.getTypeVehicle().getName()))).orElse(null);
    }

    @Override
    public Vehicle getByLicense(String license)
    {
        VehicleEntity vehicle = this.vehicleDAO.findByLicense(license);

        return Vehicle.create(vehicle.getCode(), vehicle.getLicense(), TypeVehicle.create(vehicle.getTypeVehicle().getCode(), vehicle.getTypeVehicle().getName()));
    }

    @Override
    public void save(Vehicle vehicle)
    {
        TypeVehicleEntity typeVehicle = this.typeVehicleDAO.findById(vehicle.getTypeVehicle().getCode()).map(entity -> new TypeVehicleEntity(entity.getCode(), entity.getName())).orElse(null);

        this.vehicleDAO.save(new VehicleEntity(vehicle.getCode(), vehicle.getLicense(), typeVehicle));
    }

    @Override
    public boolean exists(Vehicle vehicle)
    {
        return this.vehicleDAO.existsById(vehicle.getCode());
    }
}
