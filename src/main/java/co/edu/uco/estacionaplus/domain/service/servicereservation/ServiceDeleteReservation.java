package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteReservation
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This reservation doesn't exists with this code";

    private final ReservationRepository reservationRepository;

    public ServiceDeleteReservation(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public void delete(int code)
    {
        if(this.reservationRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.reservationRepository.delete(code);
    }
}