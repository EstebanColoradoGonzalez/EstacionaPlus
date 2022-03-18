package co.edu.uco.estacionaplus.domain.service.servicevehicle;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.TypeVehicleRepository;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceSaveVehicle
{
    private static final String MESSAGE_IT_EXISTS = "There is already some vehicle with this license.";

    private final VehicleRepository vehicleRepository;
    private final TypeVehicleRepository typeVehicleRepository;

    public ServiceSaveVehicle(VehicleRepository vehicleRepository, TypeVehicleRepository typeVehicleRepository)
    {
        this.vehicleRepository = vehicleRepository;
        this.typeVehicleRepository = typeVehicleRepository;
    }

    public void save(Vehicle vehicle)
    {
        checkTypeVehicleDoesNotExists(vehicle.getTypeVehicle());
        checkVehicleDoesNotExistsWithLicense(vehicle);

        this.vehicleRepository.save(vehicle);
    }

    private void checkVehicleDoesNotExistsWithLicense(Vehicle vehicle)
    {
        var vehicleSummary = this.vehicleRepository.getByLicense(vehicle.getLicense());

        if(!UtilObject.isNull(vehicleSummary))
        {
            throw new IllegalArgumentException(MESSAGE_IT_EXISTS);
        }
    }

    private void checkTypeVehicleDoesNotExists(TypeVehicle typeVehicle)
    {
        if(!this.typeVehicleRepository.exists(typeVehicle))
        {
            throw new IllegalArgumentException("This type of vehicle doesn't exists with this name");
        }
    }
}