package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.Getter;

@Getter
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

    private void setName(String name)
    {
        if (ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.TYPEPLACE_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException(Message.TYPEPLACE_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException(Message.TYPEPLACE_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}