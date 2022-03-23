package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceSaveReservation;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Component
public class ServiceApplicationSaveReservation
{
    private final ServiceSaveReservation serviceSaveReservation;

    public ServiceApplicationSaveReservation(ServiceSaveReservation serviceSaveReservation)
    {
        this.serviceSaveReservation = serviceSaveReservation;
    }

    public void save(ReservationDTO reservationDTO)
    {
        this.serviceSaveReservation.save(getReservationAssembler().assembleDomainFromDTO(reservationDTO));
    }
}