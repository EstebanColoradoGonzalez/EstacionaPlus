package co.edu.uco.estacionaplus.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleSummaryDTO
{
    private int code;
    private String license;
    private TypeVehicleSummaryDTO typeVehicle;
}