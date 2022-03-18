package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

public class ReservedTime
{
    private int code;
    private String value;
    private String typeTime;

    private ReservedTime(int code, String value, String typeTime)
    {
        this.code = code;
        setValue(value);
        setTypeTime(typeTime);
    }

    public static ReservedTime create(int code, String value, String typeTime)
    {
        return new ReservedTime(code, value, typeTime);
    }

    public int getCode()
    {
        return code;
    }

    public String getValue()
    {
        return value;
    }

    private void setValue(String value)
    {
        if (UtilText.isStringEmpty(value))
        {
            throw new IllegalArgumentException("The value of a ReservedTime cannot be empty.");
        }

        if(!UtilText.isLengthValid(value,1, 8))
        {
            throw new IllegalArgumentException("The value of a ReservedTime must have a minimum of 1 character and a maximum of 8 characters.");
        }

        if(!UtilText.isStringAlphanumeric(value))
        {
            throw new IllegalArgumentException("The value of a ReservedTime can only contain numbers and colons.");
        }

        this.value = value;
    }

    public String getTypeTime()
    {
        return typeTime;
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