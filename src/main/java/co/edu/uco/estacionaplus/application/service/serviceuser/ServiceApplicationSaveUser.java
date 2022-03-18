package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceSaveUser;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationSaveUser
{
    private final ServiceSaveUser serviceSaveUser;

    public ServiceApplicationSaveUser(ServiceSaveUser serviceSaveUser)
    {
        this.serviceSaveUser = serviceSaveUser;
    }

    public void save(UserDTO userDTO)
    {
        User user = User.create(userDTO.getCode(), userDTO.getNames(), userDTO.getLastNames(), userDTO.getIdentificationNumber(), userDTO.getPhone(), userDTO.getEmail(), userDTO.getPassword(), UserRole.create(userDTO.getUserRole().getCode(), userDTO.getUserRole().getName()), Vehicle.create(userDTO.getVehicle().getCode(), userDTO.getVehicle().getLicense(), TypeVehicle.create(userDTO.getVehicle().getTypeVehicle().getCode(), userDTO.getVehicle().getTypeVehicle().getName())));

        this.serviceSaveUser.save(user);
    }
}
