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

    public VehicleDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public VehicleDTOTestDataBuilder withLicense(String license)
    {
        this.license = license;
        return this;
    }

    public VehicleDTOTestDataBuilder withTypeVehicle(TypeVehicleDTOTestDataBuilder typeVehicle)
    {
        this.typeVehicle = typeVehicle;
        return this;
    }

    public VehicleDTO build()
    {
        return new VehicleDTO(code, license, typeVehicle.build());
    }
}
