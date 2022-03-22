package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteReservation
{
    private final ReservationRepository reservationRepository;

    public ServiceDeleteReservation(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public void delete(int code)
    {
        if(this.reservationRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.reservationRepository.delete(code);
    }
}