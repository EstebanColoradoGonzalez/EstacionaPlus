package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class PaymentMethod
{
    private int code;
    private String name;

    private PaymentMethod(int code, String name)
    {
        this.code = code;
        setName(name);
    }

    public static PaymentMethod create(int code, String name)
    {
        return new PaymentMethod(code, name);
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The name of a Payment Method cannot be empty.");
        }

        if(!UtilText.isLengthValid(name, 1, 20))
        {
            throw new IllegalArgumentException("The name of a Payment Method must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(name))
        {
            throw new IllegalArgumentException("The name of a Payment Method can only contain letters and spaces.");
        }

        this.name = name;
    }
}