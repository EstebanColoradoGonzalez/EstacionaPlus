package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceGetUserParkingByCode;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserParkingAssemblerImplementation.getUserParkingAssembler;

@Component
public class ServiceApplicationGetUserParkingByCode
{
    private final ServiceGetUserParkingByCode serviceGetUserParkingByCode;

    public ServiceApplicationGetUserParkingByCode(ServiceGetUserParkingByCode serviceGetUserParkingByCode)
    {
        this.serviceGetUserParkingByCode = serviceGetUserParkingByCode;
    }

    public UserParkingDTO getByCode(int code)
    {
        return getUserParkingAssembler().assembleDTOFromDomain(this.serviceGetUserParkingByCode.getByCode(code));
    }
}