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
public class VehicleDTO
{
    private int code;
    private String license;
    private TypeVehicleDTO typeVehicle;

    public static VehicleDTO create()
    {
        return new VehicleDTO(0, ValidateString.EMPTY, TypeVehicleDTO.create());
    }
}