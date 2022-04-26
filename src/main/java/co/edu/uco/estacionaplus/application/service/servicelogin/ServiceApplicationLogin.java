package co.edu.uco.estacionaplus.application.service.servicelogin;

import co.edu.uco.estacionaplus.application.dto.LoginDTO;
import co.edu.uco.estacionaplus.domain.service.servicelogin.ServiceLogin;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationLogin
{
    private final ServiceLogin serviceLogin;

    public ServiceApplicationLogin(ServiceLogin serviceLogin)
    {
        this.serviceLogin = serviceLogin;
    }

    public String login(LoginDTO login)
    {
        return this.serviceLogin.validateCredentials(login.getEmail(), login.getPassword());
    }
}