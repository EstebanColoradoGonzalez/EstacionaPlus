package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

public class ReservationDTOTestDataBuilder
{
    private int code;
    private String date;
    private String arrivalTime;
    private String departureTime;
    private ReservedTimeDTOTestDataBuilder reservedTime;
    private PriceDTOTestDataBuilder price;
    private ParkingPlaceDTOTestDataBuilder place;
    private PaymentMethodDTOTestDataBuilder paymentMethod;
    private UserDTOTestDataBuilder user;
}