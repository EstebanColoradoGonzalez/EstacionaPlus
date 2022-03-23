package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.PaymentMethod;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.Price;
import co.edu.uco.estacionaplus.domain.model.Reservation;
import co.edu.uco.estacionaplus.domain.port.PaymentMethodRepository;
import co.edu.uco.estacionaplus.domain.port.PlaceRepository;
import co.edu.uco.estacionaplus.domain.port.ReservationRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import org.springframework.stereotype.Service;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PriceAssemblerImplementation.getPriceAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservationAssemblerImplementation.getReservationAssembler;

@Service
public class ServiceModifyReservation
{
    private final ReservationRepository reservationRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PlaceRepository placeRepository;

    public ServiceModifyReservation(ReservationRepository reservationRepository, PaymentMethodRepository paymentMethodRepository, PlaceRepository placeRepository)
    {
        this.reservationRepository = reservationRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.placeRepository = placeRepository;
    }

    public void modify(int code, Reservation reservation)
    {
        checkPaymentMethodDoesNotExists(reservation.getPaymentMethod());
        checkPlaceIsTaken(reservation.getPlace());
        var price = calculatePrice(reservation.getReservedTime().getValue());
        var departureTime = calculateDepartureTime(reservation.getArrivalTime(), reservation.getReservedTime().getTypeTime(), reservation.getReservedTime().getValue());

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

    private static String calculateDepartureTime(String arrivalTime, String typeTime, int value)
    {
        String departureTime = "00:00:00";
        int hours = 0;
        int minutes = 0;

        int finalHour = 0;

        for(var i = 0; i < arrivalTime.length(); i++)
        {
            if(UtilNumber.isNumberTheSame(i, 0))
            {
                hours = concatenateCharacters(i, arrivalTime);
            }

            if(UtilNumber.isNumberTheSame(i, 3))
            {
                minutes = concatenateCharacters(i, arrivalTime);
            }
        }

        if(typeTime.equals("Hora"))
        {
            finalHour = hours + value;
        }

        if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 1)
        {
            departureTime = "0" + finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 1)
        {
            departureTime = finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 2)
        {
            departureTime = "0" + finalHour + ":" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 2)
        {
            departureTime = finalHour + ":" + minutes + ":00";
        }

        return departureTime;
    }

    private static int concatenateCharacters(int index, String arrivalTime)
    {
        return Integer.parseInt("" + arrivalTime.charAt(index) + arrivalTime.charAt(index+1));
    }

    private Price calculatePrice(int arrivalTime)
    {
        return Price.create(0, (double) 2000 * arrivalTime);
    }
}