package co.edu.uco.estacionaplus.application.service.servicelogin;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.service.servicelogin.ServiceValidateCredentials;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationValidateCredentials
{
    private final ServiceValidateCredentials serviceValidateCredentials;

    public ServiceApplicationValidateCredentials(ServiceValidateCredentials serviceValidateCredentials)
    {
        this.serviceValidateCredentials = serviceValidateCredentials;
    }

    public boolean validateCredentials(UserDTO user)
    {
        return this.serviceValidateCredentials.validateCredentials(user.getEmail(), user.getPassword());
    }
}