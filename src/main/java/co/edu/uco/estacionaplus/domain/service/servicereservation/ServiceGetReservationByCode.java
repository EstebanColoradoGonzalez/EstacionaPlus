package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetReservationByCode
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This reservation doesn't exists with this code";

    private final ReservationRepository reservationRepository;

    public ServiceGetReservationByCode(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getByCode(int code)
    {
        if(!this.reservationRepository.exists(this.reservationRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }
        return this.reservationRepository.getByCode(code);
    }
}