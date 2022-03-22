package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
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

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException(UtilMessage.STATE_NAME_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException(UtilMessage.STATE_NAME_CHECK_LENGTH_VALID);
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(UtilMessage.STATE_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}