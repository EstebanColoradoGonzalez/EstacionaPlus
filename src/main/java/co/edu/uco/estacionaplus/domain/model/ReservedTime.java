package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
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
        if (UtilNumber.isNumberLess(value, 0))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVEDTIME_VALUE_CHECK_NUMBER);
        }

        this.value = value;
    }

    private void setTypeTime(String typeTime)
    {
        if (UtilText.isStringEmpty(typeTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVEDTIME_TYPETIME_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(typeTime, 1, 10))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVEDTIME_TYPETIME_CHECK_LENGTH_VALID);
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(typeTime))
        {
            throw new IllegalArgumentException(UtilMessage.RESERVEDTIME_TYPETIME_CHECK_PATTERN);
        }

        this.typeTime = typeTime;
    }
}