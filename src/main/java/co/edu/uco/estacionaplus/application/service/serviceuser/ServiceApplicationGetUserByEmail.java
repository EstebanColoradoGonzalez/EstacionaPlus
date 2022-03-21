package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceGetUserByEmail;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetUserByEmail
{
    private final ServiceGetUserByEmail serviceGetUserByEmail;

    public ServiceApplicationGetUserByEmail(ServiceGetUserByEmail serviceGetUserByEmail)
    {
        this.serviceGetUserByEmail = serviceGetUserByEmail;
    }

    public UserSummaryDTO getByEmail(String email)
    {
        UserSummaryDTO user = this.serviceGetUserByEmail.getByEmail(email);
        return new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), new UserRoleSummaryDTO(user.getUserRole().getCode(), user.getUserRole().getName()), new VehicleSummaryDTO(user.getVehicle().getCode(), user.getVehicle().getLicense(), new TypeVehicleSummaryDTO(user.getVehicle().getTypeVehicle().getCode(), user.getVehicle().getTypeVehicle().getName())));
    }
}