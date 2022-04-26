package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.formatter.FormatTime;
import org.springframework.stereotype.Service;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PriceAssemblerImplementation.getPriceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Service
public class ServiceSaveReservation
{
    private final ReservationRepository reservationRepository;
    private final PlaceRepository placeRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;
    private final ServiceBusinessRules serviceBusinessRules;

    public ServiceSaveReservation(ReservationRepository reservationRepository, PlaceRepository placeRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, ServiceBusinessRules serviceBusinessRules)
    {
        this.reservationRepository = reservationRepository;
        this.placeRepository = placeRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.serviceBusinessRules = serviceBusinessRules;
    }

    public void save(Reservation reservation)
    {
        checkPlaceDoesNotExists(reservation.getPlace());
        checkPaymentMethodDoesNotExists(reservation.getPaymentMethod());
        checkUserDoesNotExists(reservation.getUser());
        checkPlaceIsTaken(reservation.getPlace());

        var price = serviceBusinessRules.calculatePrice(reservation.getReservedTime().getValue());
        var departureTime = serviceBusinessRules.calculateDepartureTime(FormatTime.getStringTime(reservation.getArrivalTime()), reservation.getReservedTime().getTypeTime(), reservation.getReservedTime().getValue());

        var reservationDTO = getReservationAssembler().assembleDTOFromDomain(reservation);
        reservationDTO.setPrice(getPriceAssembler().assembleDTOFromDomain(price));
        reservationDTO.setDepartureTime(departureTime);

        this.reservationRepository.save(getReservationAssembler().assembleDomainFromDTO(reservationDTO));
        this.placeRepository.modify(reservation.getPlace().getCode(), getPlaceAssembler().assembleDomainFromDTO(reservationDTO.getPlace(), true));
    }

    private void checkPlaceIsTaken(Place place)
    {
        var object = this.placeRepository.getByPosition(place.getPosition());

        if(object.isTaken())
        {
            throw new IllegalArgumentException(Message.MESSAGE_PLACE_IS_TAKEN);
        }
    }

    private void checkPlaceDoesNotExists(Place place)
    {
        if(!this.placeRepository.exists(place))
        {
            throw new IllegalArgumentException(Message.MESSAGE_PLACE_DOES_NOT_EXISTS);
        }
    }

    private void checkPaymentMethodDoesNotExists(PaymentMethod paymentMethod)
    {
        if(!this.paymentMethodRepository.exists(paymentMethod))
        {
            throw new IllegalArgumentException(Message.MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS);
        }
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(getUserAssembler().assembleSummaryDTOFromDomain(user)))
        {
            throw new IllegalArgumentException(Message.MESSAGE_USER_DOES_NOT_EXISTS);
        }
    }
}