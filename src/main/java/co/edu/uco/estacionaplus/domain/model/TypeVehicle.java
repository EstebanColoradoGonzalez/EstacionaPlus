package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class TypeVehicle
{
    private int code;
    private String name;

    private TypeVehicle(int code, String name)
    {
        this.code = code;
        setName(name);
    }

    public static TypeVehicle create(int code, String name)
    {
        return new TypeVehicle(code, name);
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a Type of Vehicle cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a Type of Vehicle must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException("The name of a Type of Vehicle can only contain letters and spaces.");
        }

        this.name = name;
    }
}