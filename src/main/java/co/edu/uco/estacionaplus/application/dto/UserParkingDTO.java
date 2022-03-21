package co.edu.uco.estacionaplus.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserParkingDTO
{
    private int code;
    private UserDTO user;
    private ParkingDTO parking;
}