package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import java.util.Date;

public class ReservationEntity
{
    private int code;
    private Date date;
    private String arrivalTime;
    private String departureTime;
    private ReservedTimeEntity reservedTime;
    private PriceEntity price;
    private PlaceEntity place;
    private PaymentMethodEntity paymentMethod;
    private UserEntity user;

    public ReservationEntity()
    {

    }

    public ReservationEntity(int code, Date date, String arrivalTime, String departureTime, ReservedTimeEntity reservedTime, PriceEntity price, PlaceEntity place, PaymentMethodEntity paymentMethod, UserEntity user)
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

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public ReservedTimeEntity getReservedTime()
    {
        return reservedTime;
    }

    public void setReservedTime(ReservedTimeEntity reservedTime)
    {
        this.reservedTime = reservedTime;
    }

    public PriceEntity getPrice()
    {
        return price;
    }

    public void setPrice(PriceEntity price)
    {
        this.price = price;
    }

    public PlaceEntity getPlace()
    {
        return place;
    }

    public void setPlace(PlaceEntity place)
    {
        this.place = place;
    }

    public PaymentMethodEntity getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEntity paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }
}