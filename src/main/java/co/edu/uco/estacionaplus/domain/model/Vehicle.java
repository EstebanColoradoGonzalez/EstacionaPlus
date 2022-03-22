package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class Vehicle
{
    private int code;
    private String license;
    private TypeVehicle typeVehicle;

    private Vehicle(int code, String license, TypeVehicle typeVehicle)
    {
        this.code = code;
        setLicense(license);
        this.typeVehicle = typeVehicle;
    }

    public static Vehicle create(int code, String license, TypeVehicle typeVehicle)
    {
        return new Vehicle(code, license, typeVehicle);
    }

    private void setLicense(String license)
    {
        if (UtilText.isStringEmpty(license))
        {
            throw new IllegalArgumentException(UtilMessage.VEHICLE_LICENSE_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(license,1, 6))
        {
            throw new IllegalArgumentException(UtilMessage.VEHICLE_LICENSE_CHECK_LENGTH_VALID);
        }

        if(!UtilText.isStringAlphanumeric(license))
        {
            throw new IllegalArgumentException(UtilMessage.VEHICLE_LICENSE_CHECK_PATTERN);
        }

        this.license = license;
    }
}