package co.edu.uco.estacionaplus.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

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
    private PlaceDTO place;
    private PaymentMethodDTO paymentMethod;
    private UserDTO user;
}