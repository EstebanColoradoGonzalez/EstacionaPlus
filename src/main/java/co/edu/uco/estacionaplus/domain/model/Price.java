package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import lombok.Getter;

@Getter
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

    private void setValue(double value)
    {
        if(UtilNumber.isNumberLessThanOrEqual(value, 0))
        {
            throw new IllegalArgumentException("The value of a Price cannot be less than or equal to zero.");
        }

        this.value = value;
    }
}