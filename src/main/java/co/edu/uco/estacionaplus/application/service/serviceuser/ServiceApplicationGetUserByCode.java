package co.edu.uco.estacionaplus.application.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuser.ServiceGetUserByCode;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationGetUserByCode
{
    private final ServiceGetUserByCode serviceGetUserByCode;

    public ServiceApplicationGetUserByCode(ServiceGetUserByCode serviceGetUserByCode)
    {
        this.serviceGetUserByCode = serviceGetUserByCode;
    }

    public UserSummaryDTO getByCode(int code)
    {
        return this.serviceGetUserByCode.getByCode(code);
    }
}