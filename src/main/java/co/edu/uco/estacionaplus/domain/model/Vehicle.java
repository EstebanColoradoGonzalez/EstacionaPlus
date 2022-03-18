package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

public class Vehicle
{
    private int code;
    private String license;
    private TypeVehicle typeVehicle;

    private Vehicle(int code, String license, TypeVehicle typeVehicle)
    {
        this.code = code;
        setLicense(license);
        setTypeVehicle(typeVehicle);
    }

    public static Vehicle create(int code, String license, TypeVehicle typeVehicle)
    {
        return new Vehicle(code, license, typeVehicle);
    }

    public int getCode()
    {
        return code;
    }

    public String getLicense()
    {
        return license;
    }

    private void setLicense(String license)
    {
        if (UtilText.isStringEmpty(license))
        {
            throw new IllegalArgumentException("The license of a Vehicle cannot be empty.");
        }

        if(!UtilText.isLengthValid(license,1, 6))
        {
            throw new IllegalArgumentException("The license of a Vehicle must have a minimum of 1 character and a maximum of 6 characters.");
        }

        if(!UtilText.isStringAlphanumeric(license))
        {
            throw new IllegalArgumentException("The value of a Vehicle must be alphanumeric.");
        }

        this.license = license;
    }

    public TypeVehicle getTypeVehicle()
    {
        return typeVehicle;
    }

    private void setTypeVehicle(TypeVehicle typeVehicle)
    {
        this.typeVehicle = typeVehicle;
    }
}