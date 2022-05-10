package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.model.ParkingPlace;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservationEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;

public interface ReservationAssembler extends Assembler<Reservation, ReservationEntity, ReservationDTO>
{
    ReservationEntity assembleEntityFromDomainToSave(Reservation domain, UserEntity user, PaymentMethod paymentMethod, ParkingPlace place);
    ReservationEntity assembleEntityFromDomainToModify(int code, Reservation domain);
}