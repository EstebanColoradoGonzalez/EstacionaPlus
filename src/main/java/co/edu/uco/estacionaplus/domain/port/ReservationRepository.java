package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Reservation;

public interface ReservationRepository
{
    Reservation getByCode(int code);
    void save(Reservation reservation);
    void modify(int code, Reservation reservation);
    void delete(int code);
    boolean exists(Reservation reservation);
}