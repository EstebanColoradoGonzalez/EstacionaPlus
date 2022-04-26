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
public class TypeVehicleDTO
{
    private int code;
    private String name;

    public static TypeVehicleDTO create()
    {
        return new TypeVehicleDTO(0, ValidateString.EMPTY);
    }
}