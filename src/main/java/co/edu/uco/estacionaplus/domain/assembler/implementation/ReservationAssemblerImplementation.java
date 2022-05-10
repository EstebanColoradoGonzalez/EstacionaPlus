package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.assembler.ReservationAssembler;
import co.edu.uco.estacionaplus.domain.formatter.FormatDate;
import co.edu.uco.estacionaplus.domain.formatter.FormatTime;
import co.edu.uco.estacionaplus.domain.model.ParkingPlace;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservationEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingPlaceAssemblerImplementation.getParkingPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PaymentMethodAssemblerImplementation.getPaymentMethodAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PriceAssemblerImplementation.getPriceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservedTimeAssemblerImplementation.getReservedTimeAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

public class ReservationAssemblerImplementation implements ReservationAssembler
{
    private static final ReservationAssembler INSTANCE = new ReservationAssemblerImplementation();

    private ReservationAssemblerImplementation()
    {

    }

    public static ReservationAssembler getReservationAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Reservation assembleDomainFromEntity(ReservationEntity entity)
    {
        return Reservation.create(entity.getCode(), entity.getDate(), entity.getArrivalTime(), entity.getDepartureTime(), getReservedTimeAssembler().assembleDomainFromEntity(entity.getReservedTime()), getPriceAssembler().assembleDomainFromEntity(entity.getPrice()), getParkingPlaceAssembler().assembleDomainFromEntity(entity.getPlace()), getPaymentMethodAssembler().assembleDomainFromEntity(entity.getPaymentMethod()), getUserAssembler().assembleDomainFromEntity(entity.getUser()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomain(Reservation domain)
    {
        return new ReservationEntity(domain.getCode(), domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getParkingPlaceAssembler().assembleEntityFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleEntityFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleEntityFromDomain(domain.getUser()));
    }

    @Override
    public Reservation assembleDomainFromDTO(ReservationDTO dto)
    {
        return Reservation.create(dto.getCode(), FormatDate.getDate(dto.getDate()), FormatTime.getTime(dto.getArrivalTime()), FormatTime.getTime(dto.getDepartureTime()), getReservedTimeAssembler().assembleDomainFromDTO(dto.getReservedTime()), getPriceAssembler().assembleDomainFromDTO(dto.getPrice()), getParkingPlaceAssembler().assembleDomainFromDTO(dto.getPlace()), getPaymentMethodAssembler().assembleDomainFromDTO(dto.getPaymentMethod()), getUserAssembler().assembleDomainFromDTO(dto.getUser()));
    }

    @Override
    public ReservationDTO assembleDTOFromDomain(Reservation domain)
    {
        return new ReservationDTO(domain.getCode(), FormatDate.getStringDate(domain.getDate()), FormatTime.getStringTime(domain.getArrivalTime()), FormatTime.getStringTime(domain.getDepartureTime()), getReservedTimeAssembler().assembleDTOFromDomain(domain.getReservedTime()), getPriceAssembler().assembleDTOFromDomain(domain.getPrice()), getParkingPlaceAssembler().assembleDTOFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleDTOFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleDTOFromDomain(domain.getUser()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomainToSave(Reservation domain, UserEntity user, PaymentMethod paymentMethod, ParkingPlace place)
    {
        return new ReservationEntity(domain.getCode(), domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getParkingPlaceAssembler().assembleEntityFromDomain(place), getPaymentMethodAssembler().assembleEntityFromDomain(paymentMethod), user);
    }

    @Override
    public ReservationEntity assembleEntityFromDomainToModify(int code, Reservation domain)
    {
        return new ReservationEntity(code, domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getParkingPlaceAssembler().assembleEntityFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleEntityFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleEntityFromDomain(domain.getUser()));
    }
}