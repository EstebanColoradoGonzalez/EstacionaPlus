package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceDeleteUserParking;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteUserParking
{
    private final ServiceDeleteUserParking serviceDelete;

    public ServiceApplicationDeleteUserParking(ServiceDeleteUserParking serviceDelete)
    {
        this.serviceDelete = serviceDelete;
    }

    public void delete(int code)
    {
        this.serviceDelete.delete(code);
    }
}