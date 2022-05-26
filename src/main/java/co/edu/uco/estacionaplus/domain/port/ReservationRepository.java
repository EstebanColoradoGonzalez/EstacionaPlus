package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Reservation;

import java.util.List;

public interface ReservationRepository
{
    List<Reservation> getAll();
    Reservation getByCode(int code);
    void save(Reservation reservation);
    void modify(int code, Reservation reservation);
    void delete(int code);
    boolean exists(Reservation reservation);
}