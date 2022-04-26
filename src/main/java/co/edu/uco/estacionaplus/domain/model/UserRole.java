package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
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
        if (ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.USERROLE_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException(Message.USERROLE_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException(Message.USERROLE_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }
}