package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class City
{
    private int code;
    private String name;
    private State state;

    private City(int code, String name, State state)
    {
        this.code = code;
        setName(name);
        this.state = state;
    }

    public static City create(int code, String name, State state)
    {
        return new City(code, name, state);
    }


    private void setName(String name)
    {
        if(UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a City cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a City must have a minimum of 1 character and a maximum of 50 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException("The name of a City can only contain letters and spaces.");
        }

        this.name = name;
    }
}