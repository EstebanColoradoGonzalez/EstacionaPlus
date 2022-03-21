package co.edu.uco.estacionaplus.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParkingDTO
{
    private int code;
    private String nit;
    private String name;
    private String address;
    private CityDTO city;
    private List<PlaceDTO> places;
}