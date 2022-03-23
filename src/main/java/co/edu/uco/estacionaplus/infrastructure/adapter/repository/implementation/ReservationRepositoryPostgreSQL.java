package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PaymentMethodDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PlaceDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ReservationDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import org.springframework.stereotype.Repository;

import static co.edu.uco.estacionaplus.domain.assembler.implementation.PaymentMethodAssemblerImplementation.getPaymentMethodAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Repository
public class ReservationRepositoryPostgreSQL implements ReservationRepository
{
    private final ReservationDAO reservationDAO;
    private final UserDAO userDAO;
    private final PaymentMethodDAO paymentMethodDAO;
    private final PlaceDAO placeDAO;

    public ReservationRepositoryPostgreSQL(ReservationDAO reservationDAO, UserDAO userDAO, PaymentMethodDAO paymentMethodDAO, PlaceDAO placeDAO)
    {
        this.reservationDAO = reservationDAO;
        this.userDAO = userDAO;
        this.paymentMethodDAO = paymentMethodDAO;
        this.placeDAO = placeDAO;
    }

    @Override
    public Reservation getByCode(int code)
    {
        return this.reservationDAO.findById(code).map(getReservationAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(Reservation reservation)
    {
        var user = this.userDAO.findById(reservation.getUser().getCode()).map(getUserAssembler()::assembleDomainFromEntity).orElse(null);
        var paymentMethod = this.paymentMethodDAO.findById(reservation.getPaymentMethod().getCode()).map(getPaymentMethodAssembler()::assembleDomainFromEntity).orElse(null);
        var place = this.placeDAO.findById(reservation.getPlace().getCode()).map(getPlaceAssembler()::assembleDomainFromEntity).orElse(null);

        this.reservationDAO.save(getReservationAssembler().assembleEntityFromDomainToSave(reservation, user, paymentMethod, place));
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