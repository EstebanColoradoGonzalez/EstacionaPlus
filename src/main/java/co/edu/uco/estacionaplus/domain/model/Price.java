package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
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
            throw new IllegalArgumentException(UtilMessage.PRICE_VALUE_CHECK_NUMBER);
        }

        this.value = value;
    }
}