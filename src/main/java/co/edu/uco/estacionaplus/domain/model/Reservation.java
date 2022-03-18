package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

import java.util.Date;

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
        setReservedTime(reservedTime);
        setPrice(price);
        setPlace(place);
        setPaymentMethod(paymentMethod);
        setUser(user);
    }

    public static Reservation create(int code, Date date, String arrivalTime, String departureTime, ReservedTime reservedTime, Price price, Place place, PaymentMethod paymentMethod, User user)
    {
        return new Reservation(code, date, arrivalTime, departureTime, reservedTime, price, place, paymentMethod, user);
    }

    public int getCode()
    {
        return code;
    }

    public Date getDate()
    {
        return date;
    }

    private void setDate(Date date)
    {
        this.date = date;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime)
    {
        if (UtilText.isStringEmpty(arrivalTime))
        {
            throw new IllegalArgumentException("The arrivalTime of a Reservation cannot be empty.");
        }

        if(!UtilText.isLengthValid(arrivalTime,1, 10))
        {
            throw new IllegalArgumentException("The arrivalTime of a Reservation must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.isStringAlphanumeric(arrivalTime))
        {
            throw new IllegalArgumentException("The arrivalTime of a Reservation can only contain characters.");
        }

        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    private void setDepartureTime(String departureTime)
    {
        if (UtilText.isStringEmpty(departureTime))
        {
            throw new IllegalArgumentException("The departureTime of a Reservation cannot be empty.");
        }

        if(!UtilText.isLengthValid(departureTime,1, 10))
        {
            throw new IllegalArgumentException("The departureTime of a Reservation must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.isStringAlphanumeric(departureTime))
        {
            throw new IllegalArgumentException("The departureTime of a Reservation can only contain characters.");
        }

        this.departureTime = departureTime;
    }

    public ReservedTime getReservedTime()
    {
        return reservedTime;
    }

    private void setReservedTime(ReservedTime reservedTime)
    {
        this.reservedTime = reservedTime;
    }

    public Price getPrice()
    {
        return price;
    }

    private void setPrice(Price price)
    {
        this.price = price;
    }

    public Place getPlace()
    {
        return place;
    }

    private void setPlace(Place place)
    {
        this.place = place;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public User getUser()
    {
        return user;
    }

    private void setUser(User user)
    {
        this.user = user;
    }
}