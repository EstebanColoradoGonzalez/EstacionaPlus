package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

public class State
{
    private int code;
    private String name;

    private State(int code, String name)
    {
        this.code = code;
        setName(name);
    }

    public static State create(int code, String name)
    {
        return new State(code, name);
    }

    public int getCode()
    {
        return code;
    }

    private void setCode(int code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a State cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a State must have a minimum of 1 character and a maximum of 50 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException("The name of a State can only contain letters and spaces.");
        }

        this.name = name;
    }
}