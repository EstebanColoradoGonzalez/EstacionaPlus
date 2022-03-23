package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceGetUsers;
import org.springframework.stereotype.Component;
import java.util.List;

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
        return this.serviceGetUsers.getAll();
    }
}