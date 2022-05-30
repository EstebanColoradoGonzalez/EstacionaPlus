package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.VehicleDTO;

public class VehicleDTOTestDataBuilder
{
    private int code;
    private String license;
    private TypeVehicleDTOTestDataBuilder typeVehicle;

    public VehicleDTOTestDataBuilder()
    {
        this.code = 1;
        this.license = "USV36D";
        this.typeVehicle = new TypeVehicleDTOTestDataBuilder();
    }

    public VehicleDTO build()
    {
        return new VehicleDTO(code, license, typeVehicle.build());
    }
}