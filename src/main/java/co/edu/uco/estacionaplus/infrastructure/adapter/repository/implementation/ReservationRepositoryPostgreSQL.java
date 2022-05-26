package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ParkingPlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PaymentMethodDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ReservationDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingPlaceAssemblerImplementation.getParkingPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PaymentMethodAssemblerImplementation.getPaymentMethodAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Repository
public class ReservationRepositoryPostgreSQL implements ReservationRepository
{
    private final ReservationDAO reservationDAO;
    private final UserDAO userDAO;
    private final PaymentMethodDAO paymentMethodDAO;
    private final ParkingPlaceDAO parkingPlaceDAO;

    public ReservationRepositoryPostgreSQL(ReservationDAO reservationDAO, UserDAO userDAO, PaymentMethodDAO paymentMethodDAO, ParkingPlaceDAO parkingPlaceDAO)
    {
        this.reservationDAO = reservationDAO;
        this.userDAO = userDAO;
        this.paymentMethodDAO = paymentMethodDAO;
        this.parkingPlaceDAO = parkingPlaceDAO;
    }

    @Override
    public List<Reservation> getAll()
    {
        return this.reservationDAO.findAll().stream().map(getReservationAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public Reservation getByCode(int code)
    {
        return this.reservationDAO.findById(code).map(getReservationAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(Reservation reservation)
    {
        var user = this.userDAO.findById(reservation.getUser().getCode()).orElse(null);
        var paymentMethod = this.paymentMethodDAO.findById(reservation.getPaymentMethod().getCode()).map(getPaymentMethodAssembler()::assembleDomainFromEntity).orElse(null);
        var parkingPlace = this.parkingPlaceDAO.findById(reservation.getPlace().getCode()).map(getParkingPlaceAssembler()::assembleDomainFromEntity).orElse(null);

        this.reservationDAO.save(getReservationAssembler().assembleEntityFromDomainToSave(reservation, user, paymentMethod, parkingPlace));
    }

    @Override
    public void modify(int code, Reservation reservation)
    {
        this.reservationDAO.save(getReservationAssembler().assembleEntityFromDomainToModify(code, reservation));
    }

    @Override
    public void delete(int code)
    {
        this.reservationDAO.deleteById(code);
    }

    @Override
    public boolean exists(Reservation reservation)
    {
        return this.reservationDAO.existsById(reservation.getCode());
    }
}