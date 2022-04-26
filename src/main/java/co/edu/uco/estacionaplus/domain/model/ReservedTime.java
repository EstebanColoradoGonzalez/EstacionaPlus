package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateNumber;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.Getter;

@Getter
public class ReservedTime
{
    private int code;
    private int value;
    private String typeTime;

    private ReservedTime(int code, int value, String typeTime)
    {
        this.code = code;
        setValue(value);
        setTypeTime(typeTime);
    }

    public static ReservedTime create(int code, int value, String typeTime)
    {
        return new ReservedTime(code, value, typeTime);
    }

    private void setValue(int value)
    {
        if (ValidateNumber.isNumberLess(value, 0))
        {
            throw new IllegalArgumentException(Message.RESERVEDTIME_VALUE_CHECK_NUMBER);
        }

        this.value = value;
    }

    private void setTypeTime(String typeTime)
    {
        if (ValidateString.isStringEmpty(typeTime))
        {
            throw new IllegalArgumentException(Message.RESERVEDTIME_TYPETIME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(typeTime, 1, 10))
        {
            throw new IllegalArgumentException(Message.RESERVEDTIME_TYPETIME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(typeTime))
        {
            throw new IllegalArgumentException(Message.RESERVEDTIME_TYPETIME_CHECK_PATTERN);
        }

        this.typeTime = typeTime;
    }
}