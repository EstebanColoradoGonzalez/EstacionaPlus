package co.edu.uco.estacionaplus.application.service.serviceparking;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.domain.service.serviceparking.ServiceGetParkingByCode;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingAssemblerImplementation.getParkingAssembler;

@Component
public class ServiceApplicationGetParkingByCode
{
    private final ServiceGetParkingByCode serviceGetParkingByCode;

    public ServiceApplicationGetParkingByCode(ServiceGetParkingByCode serviceGetParkingByCode)
    {
        this.serviceGetParkingByCode = serviceGetParkingByCode;
    }

    public ParkingDTO getByCode(int code)
    {
        return getParkingAssembler().assembleDTOFromDomain(this.serviceGetParkingByCode.getByCode(code));
    }
}