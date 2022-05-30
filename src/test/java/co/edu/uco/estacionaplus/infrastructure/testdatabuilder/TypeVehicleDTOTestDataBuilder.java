package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.TypeVehicleDTO;

public class TypeVehicleDTOTestDataBuilder
{
    private int code;
    private String name;

    public TypeVehicleDTOTestDataBuilder()
    {
        this.code = 1;
        this.name = "Motocicleta";
    }

    public TypeVehicleDTO build()
    {
        return new TypeVehicleDTO(code, name);
    }
}