package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceModifyUser;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationModifyUser
{
    private final ServiceModifyUser serviceModifyUser;

    public ServiceApplicationModifyUser(ServiceModifyUser serviceModifyUser)
    {
        this.serviceModifyUser = serviceModifyUser;
    }

    public void modify(int code, UserDTO userDTO)
    {
        User user = User.create(userDTO.getCode(), userDTO.getNames(), userDTO.getLastNames(), userDTO.getIdentificationNumber(), userDTO.getPhone(), userDTO.getEmail(), userDTO.getPassword(), UserRole.create(userDTO.getUserRole().getCode(), userDTO.getUserRole().getName()), Vehicle.create(userDTO.getVehicle().getCode(), userDTO.getVehicle().getLicense(), TypeVehicle.create(userDTO.getVehicle().getTypeVehicle().getCode(), userDTO.getVehicle().getTypeVehicle().getName())));

        this.serviceModifyUser.modify(code, user);
    }
}