package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
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
        return this.serviceGetUserByEmail.getByEmail(email);
    }
}