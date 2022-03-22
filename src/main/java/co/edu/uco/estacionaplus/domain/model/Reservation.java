package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;
import java.util.Date;

@Getter
public class Reservation
{
    private int code;
    private Date date;
    private String arrivalTime;
    private String departureTime;
    private ReservedTime reservedTime;
    private Price price;
    private Place place;
    private PaymentMethod paymentMethod;
    private User user;

    private Reservation(int code, Date date, String arrivalTime, String departureTime, ReservedTime reservedTime, Price price, Place place, PaymentMethod paymentMethod, User user)
    {
        this.code = code;
        setDate(date);
        setArrivalTime(arrivalTime);
        setDepartureTime(departureTime);
        this.reservedTime = reservedTime;
        this.price = price;
        this.place = place;
        this.paymentMethod = paymentMethod;
        this.user = user;
    }

    public static Reservation create(int code, Date date, String arrivalTime, String departureTime, ReservedTime reservedTime, Price price, Place place, PaymentMethod paymentMethod, User user)
    {
        return new Reservation(code, date, arrivalTime, departureTime, reservedTime, price, place, paymentMethod, user);
    }

    private void setDate(Date date)
    {
        this.date = date;
    }

    public void setArrivalTime(String arrivalTime)
    {
        if (UtilText.isStringEmpty(arrivalTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_ARRIVALTIME_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(arrivalTime,1, 10))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_ARRIVALTIME_CHECK_LENGTH_VALID);
        }

        if(!UtilText.isStringAlphanumeric(arrivalTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_ARRIVALTIME_CHECK_PATTERN);
        }

        this.arrivalTime = arrivalTime;
    }

    private void setDepartureTime(String departureTime)
    {
        if (UtilText.isStringEmpty(departureTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_DEPARTURETIME_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(departureTime,1, 10))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_DEPARTURETIME_CHECK_LENGTH_VALID);
        }

        if(!UtilText.isStringAlphanumeric(departureTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVATION_DEPARTURETIME_CHECK_PATTERN);
        }

        this.departureTime = departureTime;
    }
}