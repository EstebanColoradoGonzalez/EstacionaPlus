package co.edu.uco.estacionaplus.domain.testdatabuilder;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.model.Vehicle;

public class VehicleTestDataBuilder
{
    private int code;
    private String license;
    private TypeVehicleTestDataBuilder typeVehicle;

    public VehicleTestDataBuilder()
    {
        this.code = 1;
        this.license = "USV36D";
        this.typeVehicle = new TypeVehicleTestDataBuilder();
    }

    public VehicleTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public VehicleTestDataBuilder withLicense(String license)
    {
        this.license = license;
        return this;
    }

    public VehicleTestDataBuilder withTypeVehicle(TypeVehicleTestDataBuilder typeVehicle)
    {
        this.typeVehicle = typeVehicle;
        return this;
    }

    public Vehicle build()
    {
        return Vehicle.create(code, license, typeVehicle.build());
    }
}
