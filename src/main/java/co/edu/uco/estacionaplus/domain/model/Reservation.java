package co.edu.uco.estacionaplus.domain.model;

import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class Reservation
{
    private int code;
    private LocalDate date;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private ReservedTime reservedTime;
    private Price price;
    private Place place;
    private PaymentMethod paymentMethod;
    private User user;

    private Reservation(int code, LocalDate date, LocalTime arrivalTime, LocalTime departureTime, ReservedTime reservedTime, Price price, Place place, PaymentMethod paymentMethod, User user)
    {
        this.code = code;
        this.date = date;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.reservedTime = reservedTime;
        this.price = price;
        this.place = place;
        this.paymentMethod = paymentMethod;
        this.user = user;
    }

    public static Reservation create(int code, LocalDate date, LocalTime arrivalTime, LocalTime departureTime, ReservedTime reservedTime, Price price, Place place, PaymentMethod paymentMethod, User user)
    {
        return new Reservation(code, date, arrivalTime, departureTime, reservedTime, price, place, paymentMethod, user);
    }
}