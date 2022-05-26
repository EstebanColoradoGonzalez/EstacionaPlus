package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGetReservations
{
    private final ReservationRepository reservationRepository;

    public ServiceGetReservations(ReservationRepository reservationRepository)
    {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations()
    {
        return this.reservationRepository.getAll();
    }
}
