package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceModifyUser;
import org.springframework.stereotype.Component;

import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Component
public class ServiceApplicationModifyUser
{
    private final ServiceModifyUser serviceModifyUser;

    public ServiceApplicationModifyUser(ServiceModifyUser serviceModifyUser)
    {
        this.serviceModifyUser = serviceModifyUser;
    }

    public void modify(int code, UserDTO user)
    {
        this.serviceModifyUser.modify(code, getUserAssembler().assembleDomainFromDTO(user));
    }
}