package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetReservationByCode
{
    private final ReservationRepository reservationRepository;

    public ServiceGetReservationByCode(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getByCode(int code)
    {
        if(!this.reservationRepository.exists(this.reservationRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_MESSAGE_IT_DOES_NOT_EXISTS);
        }
        return this.reservationRepository.getByCode(code);
    }
}