package co.edu.uco.estacionaplus.application.dto;

import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityDTO
{
    private int code;
    private String name;
    private StateDTO state;

    public static CityDTO create()
    {
        return new CityDTO(0, ValidateString.EMPTY, StateDTO.create());
    }
}