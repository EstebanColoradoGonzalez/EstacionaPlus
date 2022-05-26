package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserNoSummaryDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceGetUserByEmailWithPassword;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetUserByEmailWithPassword
{
    private final ServiceGetUserByEmailWithPassword serviceGetUserByEmailWithPassword;

    public ServiceApplicationGetUserByEmailWithPassword(ServiceGetUserByEmailWithPassword serviceGetUserByEmailWithPassword)
    {
        this.serviceGetUserByEmailWithPassword = serviceGetUserByEmailWithPassword;
    }

    public UserNoSummaryDTO getByEmailWithPassword(String email)
    {

        return this.serviceGetUserByEmailWithPassword.getByEmailWithPassword(email);
    }
}