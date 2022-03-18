package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

public class TypePlace
{
    private int code;
    private String name;

    private TypePlace(int code, String name)
    {
        this.code = code;
        setName(name);
    }

    public static TypePlace create(int code, String name)
    {
        return new TypePlace(code, name);
    }

    public int getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a Type of Place cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a Type of Place must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException("The name of a Type of Place can only contain letters and spaces.");
        }

        this.name = name;
    }
}