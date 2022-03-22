package co.edu.uco.estacionaplus.domain.model;

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
            throw new IllegalArgumentException("The value of a ReservedTime cannot be less tan zero.");
        }

        this.value = value;
    }

    private void setTypeTime(String typeTime)
    {
        if (UtilText.isStringEmpty(typeTime))
        {
            throw new IllegalArgumentException("The type of Time of a ReservedTime cannot be empty.");
        }

        if(!UtilText.isLengthValid(typeTime, 1, 10))
        {
            throw new IllegalArgumentException("The type of Time of a ReservedTime must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(typeTime))
        {
            throw new IllegalArgumentException("The type of Time of a ReservedTime can only contain letters and spaces.");
        }

        this.typeTime = typeTime;
    }
}