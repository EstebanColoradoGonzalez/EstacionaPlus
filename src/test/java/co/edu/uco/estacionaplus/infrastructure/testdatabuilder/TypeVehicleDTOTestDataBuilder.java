package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.TypeVehicleDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;

public class TypeVehicleDTOTestDataBuilder
{
    private int code;
    private String name;

    public TypeVehicleDTOTestDataBuilder()
    {
        this.code = 1;
        this.name = "Motocicleta";
    }

    public TypeVehicleDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public TypeVehicleDTOTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public TypeVehicleDTO build()
    {
        return new TypeVehicleDTO(code, name);
    }
}
