package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
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
        if(ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.CITY_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException(Message.CITY_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.CITY_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}