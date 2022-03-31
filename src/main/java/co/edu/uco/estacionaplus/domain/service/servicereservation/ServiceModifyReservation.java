package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilTime;
import org.springframework.stereotype.Service;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PriceAssemblerImplementation.getPriceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Service
public class ServiceModifyReservation
{
    private final ReservationRepository reservationRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PlaceRepository placeRepository;
    private final ServiceBusinessRules serviceBusinessRules;

    public ServiceModifyReservation(ReservationRepository reservationRepository, PaymentMethodRepository paymentMethodRepository, PlaceRepository placeRepository, ServiceBusinessRules serviceBusinessRules)
    {
        this.reservationRepository = reservationRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.placeRepository = placeRepository;
        this.serviceBusinessRules = serviceBusinessRules;
    }

    public void modify(int code, Reservation reservation)
    {
        checkPaymentMethodDoesNotExists(reservation.getPaymentMethod());
        checkPlaceIsTaken(reservation.getPlace());
        var price = serviceBusinessRules.calculatePrice(reservation.getReservedTime().getValue());
        var departureTime = serviceBusinessRules.calculateDepartureTime(UtilTime.getStringTime(reservation.getArrivalTime()), reservation.getReservedTime().getTypeTime(), reservation.getReservedTime().getValue());

        var reservationDTO = getReservationAssembler().assembleDTOFromDomain(reservation);
        reservationDTO.setPrice(getPriceAssembler().assembleDTOFromDomain(price));
        reservationDTO.setDepartureTime(departureTime);

        this.reservationRepository.modify(code, getReservationAssembler().assembleDomainFromDTO(reservationDTO));
    }

    private void checkPaymentMethodDoesNotExists(PaymentMethod paymentMethod)
    {
        if(!this.paymentMethodRepository.exists(paymentMethod))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS);
        }
    }

    private void checkPlaceIsTaken(Place place)
    {
        var object = this.placeRepository.getByPosition(place.getPosition());

        if(object.isTaken())
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_PLACE_IS_TAKEN);
        }
    }
}