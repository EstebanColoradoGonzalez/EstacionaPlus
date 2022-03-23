package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceGetReservationByCode;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Component
public class ServiceApplicationGetReservationByCode
{
    private final ServiceGetReservationByCode serviceGetReservationByCode;

    public ServiceApplicationGetReservationByCode(ServiceGetReservationByCode serviceGetReservationByCode)
    {
        this.serviceGetReservationByCode = serviceGetReservationByCode;
    }

    public ReservationDTO getByCode(int code)
    {
        return getReservationAssembler().assembleDTOFromDomain(this.serviceGetReservationByCode.getByCode(code));
    }
}