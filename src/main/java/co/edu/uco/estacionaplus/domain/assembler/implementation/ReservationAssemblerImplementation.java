package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.domain.assembler.ReservationAssembler;
import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilDate;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilTime;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservationEntity;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PaymentMethodAssemblerImplementation.getPaymentMethodAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;
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
        return Reservation.create(entity.getCode(), entity.getDate(), entity.getArrivalTime(), entity.getDepartureTime(), getReservedTimeAssembler().assembleDomainFromEntity(entity.getReservedTime()), getPriceAssembler().assembleDomainFromEntity(entity.getPrice()), getPlaceAssembler().assembleDomainFromEntity(entity.getPlace()), getPaymentMethodAssembler().assembleDomainFromEntity(entity.getPaymentMethod()), getUserAssembler().assembleDomainFromEntity(entity.getUser()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomain(Reservation domain)
    {
        return new ReservationEntity(domain.getCode(), domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getPlaceAssembler().assembleEntityFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleEntityFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleEntityFromDomain(domain.getUser()));
    }

    @Override
    public Reservation assembleDomainFromDTO(ReservationDTO dto)
    {
        return Reservation.create(dto.getCode(), UtilDate.getDate(dto.getDate()), UtilTime.getTime(dto.getArrivalTime()), UtilTime.getTime(dto.getDepartureTime()), getReservedTimeAssembler().assembleDomainFromDTO(dto.getReservedTime()), getPriceAssembler().assembleDomainFromDTO(dto.getPrice()), getPlaceAssembler().assembleDomainFromDTO(dto.getPlace()), getPaymentMethodAssembler().assembleDomainFromDTO(dto.getPaymentMethod()), getUserAssembler().assembleDomainFromDTO(dto.getUser()));
    }

    @Override
    public ReservationDTO assembleDTOFromDomain(Reservation domain)
    {
        return new ReservationDTO(domain.getCode(), UtilDate.getStringDate(domain.getDate()), UtilTime.getStringTime(domain.getArrivalTime()), UtilTime.getStringTime(domain.getDepartureTime()), getReservedTimeAssembler().assembleDTOFromDomain(domain.getReservedTime()), getPriceAssembler().assembleDTOFromDomain(domain.getPrice()), getPlaceAssembler().assembleDTOFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleDTOFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleDTOFromDomain(domain.getUser()));
    }

    @Override
    public ReservationEntity assembleEntityFromDomainToSave(Reservation domain, User user, PaymentMethod paymentMethod, Place place)
    {
        return new ReservationEntity(domain.getCode(), domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getPlaceAssembler().assembleEntityFromDomain(place), getPaymentMethodAssembler().assembleEntityFromDomain(paymentMethod), getUserAssembler().assembleEntityFromDomain(user));
    }

    @Override
    public ReservationEntity assembleEntityFromDomainToModify(int code, Reservation domain)
    {
        return new ReservationEntity(code, domain.getDate(), domain.getArrivalTime(), domain.getDepartureTime(), getReservedTimeAssembler().assembleEntityFromDomain(domain.getReservedTime()), getPriceAssembler().assembleEntityFromDomain(domain.getPrice()), getPlaceAssembler().assembleEntityFromDomain(domain.getPlace()), getPaymentMethodAssembler().assembleEntityFromDomain(domain.getPaymentMethod()), getUserAssembler().assembleEntityFromDomain(domain.getUser()));
    }
}