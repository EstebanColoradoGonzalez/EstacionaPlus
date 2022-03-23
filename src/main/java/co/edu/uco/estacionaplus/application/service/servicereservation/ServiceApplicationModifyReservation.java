package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceModifyReservation;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Component
public class ServiceApplicationModifyReservation
{
    private final ServiceModifyReservation serviceModifyReservation;

    public ServiceApplicationModifyReservation(ServiceModifyReservation serviceModifyReservation)
    {
        this.serviceModifyReservation = serviceModifyReservation;
    }

    public void modify(int code, ReservationDTO reservationDTO)
    {
        this.serviceModifyReservation.modify(code, getReservationAssembler().assembleDomainFromDTO(reservationDTO));
    }
}