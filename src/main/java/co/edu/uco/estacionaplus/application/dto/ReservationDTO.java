package co.edu.uco.estacionaplus.application.dto;

import java.util.Date;

public class ReservationDTO
{
    private int code;
    private Date date;
    private String arrivalTime;
    private String departureTime;
    private ReservedTimeDTO reservedTime;
    private PriceDTO price;
    private PlaceDTO place;
    private PaymentMethodDTO paymentMethod;
    private UserDTO user;

    public ReservationDTO()
    {

    }

    public ReservationDTO(int code, Date date, String arrivalTime, String departureTime, ReservedTimeDTO reservedTime, PriceDTO price, PlaceDTO place, PaymentMethodDTO paymentMethod, UserDTO user)
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

    public ReservedTimeDTO getReservedTime()
    {
        return reservedTime;
    }

    public void setReservedTime(ReservedTimeDTO reservedTime)
    {
        this.reservedTime = reservedTime;
    }

    public PriceDTO getPrice()
    {
        return price;
    }

    public void setPrice(PriceDTO price)
    {
        this.price = price;
    }

    public PlaceDTO getPlace()
    {
        return place;
    }

    public void setPlace(PlaceDTO place)
    {
        this.place = place;
    }

    public PaymentMethodDTO getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDTO paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }
}