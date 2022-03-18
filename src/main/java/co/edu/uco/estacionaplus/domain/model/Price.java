package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;

public class Price
{
    private int code;
    private double value;

    private Price(int code, double value)
    {
        this.code = code;
        setValue(value);
    }

    public static Price create(int code, double value)
    {
        return new Price(code, value);
    }

    public int getCode()
    {
        return code;
    }

    public double getValue()
    {
        return value;
    }

    private void setValue(double value)
    {
        if(UtilNumber.isNumberLessThanOrEqual(value, 0))
        {
            throw new IllegalArgumentException("The value of a Price cannot be less than or equal to zero.");
        }

        this.value = value;
    }
}