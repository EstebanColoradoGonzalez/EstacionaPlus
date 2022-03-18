package co.edu.uco.estacionaplus.domain.testdatabuilder;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;

public class TypeVehicleTestDataBuilder
{
    private int code;
    private String name;

    public TypeVehicleTestDataBuilder()
    {
        this.code = 1;
        this.name = "Motocicleta";
    }

    public TypeVehicleTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public TypeVehicleTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public TypeVehicle build()
    {
        return TypeVehicle.create(code, name);
    }
}
