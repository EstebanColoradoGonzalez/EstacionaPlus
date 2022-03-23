package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceSaveUser;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Component
public class ServiceApplicationSaveUser
{
    private final ServiceSaveUser serviceSaveUser;

    public ServiceApplicationSaveUser(ServiceSaveUser serviceSaveUser)
    {
        this.serviceSaveUser = serviceSaveUser;
    }

    public void save(UserDTO user)
    {
        this.serviceSaveUser.save(getUserAssembler().assembleDomainFromDTO(user));
    }
}
