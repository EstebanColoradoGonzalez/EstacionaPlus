package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservationEntity;

public interface ReservationAssembler extends Assembler<Reservation, ReservationEntity, ReservationDTO>
{
    ReservationEntity assembleEntityFromDomainToSave(Reservation domain, User user, PaymentMethod paymentMethod, Place place);
    ReservationEntity assembleEntityFromDomainToModify(int code, Reservation domain);
}