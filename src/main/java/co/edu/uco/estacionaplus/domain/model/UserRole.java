package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class UserRole
{
    private int code;
    private String name;

    private UserRole(int code, String name)
    {
        this.code = code;
        setName(name);
    }

    public static UserRole create(int code, String name)
    {
        return new UserRole(code, name);
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a User Role cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a User Role must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException("The name of a User Role can only contain letters and spaces.");
        }

        this.name = name;
    }
}