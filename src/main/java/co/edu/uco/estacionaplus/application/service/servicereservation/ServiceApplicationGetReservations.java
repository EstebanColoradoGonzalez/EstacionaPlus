package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceGetReservations;
import org.springframework.stereotype.Component;

import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Component
public class ServiceApplicationGetReservations
{
    private final ServiceGetReservations serviceGetReservations;

    public ServiceApplicationGetReservations(ServiceGetReservations serviceGetReservations)
    {
        this.serviceGetReservations = serviceGetReservations;
    }

    public List<ReservationDTO> getReservations()
    {
        return getReservationAssembler().assemblerDTOsFromDomains(this.serviceGetReservations.getReservations());
    }
}
