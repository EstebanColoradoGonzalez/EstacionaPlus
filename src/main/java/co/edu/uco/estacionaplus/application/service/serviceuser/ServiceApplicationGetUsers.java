package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.application.dto.TypeVehicleDTO;
import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import co.edu.uco.estacionaplus.application.dto.VehicleDTO;
import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceGetUsers;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceApplicationGetUsers
{
    private final ServiceGetUsers serviceGetUsers;

    public ServiceApplicationGetUsers(ServiceGetUsers serviceGetUsers)
    {
        this.serviceGetUsers = serviceGetUsers;
    }

    public List<UserSummaryDTO> getAll()
    {
        return this.serviceGetUsers.getAll().stream().map(user -> new UserSummaryDTO(user.getCode(), user.getNames(), user.getLastNames(), user.getIdentificationNumber(), user.getPhone(), user.getEmail(), new UserRoleSummaryDTO(user.getUserRole().getCode(), user.getUserRole().getName()), new VehicleSummaryDTO(user.getVehicle().getCode(), user.getVehicle().getLicense(), new TypeVehicleSummaryDTO(user.getVehicle().getTypeVehicle().getCode(), user.getVehicle().getTypeVehicle().getName())))).collect(Collectors.toList());
    }
}