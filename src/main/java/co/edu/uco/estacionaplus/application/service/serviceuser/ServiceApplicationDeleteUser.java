package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceDeleteUser;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteUser
{
    private final ServiceDeleteUser serviceDelete;

    public ServiceApplicationDeleteUser(ServiceDeleteUser serviceDelete)
    {
        this.serviceDelete = serviceDelete;
    }

    public void delete(int code)
    {
        this.serviceDelete.delete(code);
    }
}