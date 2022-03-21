package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceModifyUser
{
    private static final String MESSAGE_EXISTS_WITH_EMAIL = "There is already someone with this email.";
    private static final String MESSAGE_EXISTS_WITH_IDENTIFICATION_NUMBER = "There is already someone with this identification number.";
    private static final String MESSAGE_VEHICLE_EXISTS_WITH_LICENSE = "There is already some car with this license.";

    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public ServiceModifyUser(UserRepository userRepository, VehicleRepository vehicleRepository)
    {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void modify(int code, User user)
    {
        checkUserDoesNotExistsWithEmail(code, user);
        checkUserDoesNotExistsWithIdentificationNumber(code, user);
        checkVehicleDoesNotExistsWithLicense(user.getVehicle());
        this.userRepository.modify(code, user);
    }

    private void checkUserDoesNotExistsWithEmail(int code, User user)
    {
        var userSummary = this.userRepository.getByEmail(user.getEmail());

        if(!UtilObject.isNull(userSummary) && userSummary.getCode() != code)
        {
            throw new IllegalArgumentException(MESSAGE_EXISTS_WITH_EMAIL);
        }
    }

    private void checkUserDoesNotExistsWithIdentificationNumber(int code, User user)
    {
        var userSummary = this.userRepository.getByIdentificationNumber(user.getIdentificationNumber());

        if(!UtilObject.isNull(userSummary) && userSummary.getCode() != code)
        {
            throw new IllegalArgumentException(MESSAGE_EXISTS_WITH_IDENTIFICATION_NUMBER);
        }
    }

    private void checkVehicleDoesNotExistsWithLicense(Vehicle vehicle)
    {
        var vehicleSummary = this.vehicleRepository.getByLicense(vehicle.getLicense());

        if(!UtilObject.isNull(vehicleSummary) && vehicleSummary.getCode() != vehicle.getCode())
        {
            throw new IllegalArgumentException(MESSAGE_VEHICLE_EXISTS_WITH_LICENSE);
        }
    }
}