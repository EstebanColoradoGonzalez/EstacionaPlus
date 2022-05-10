package co.edu.uco.estacionaplus.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO
{
    private int code;
    private String date;
    private String arrivalTime;
    private String departureTime;
    private ReservedTimeDTO reservedTime;
    private PriceDTO price;
    private ParkingPlaceDTO place;
    private PaymentMethodDTO paymentMethod;
    private UserDTO user;
}