package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class Place
{
    private int code;
    private String position;
    private boolean taken;
    private TypePlace typePlace;

    private Place(int code, String position, boolean taken, TypePlace typePlace)
    {
        this.code = code;
        setPosition(position);
        this.typePlace = typePlace;
        this.taken = taken;
    }

    public static Place create(int code, String position, boolean taken, TypePlace typePlace)
    {
        return new Place(code, position, taken, typePlace);
    }

    private void setPosition(String position)
    {
        if (UtilText.isStringEmpty(position))
        {
            throw new IllegalArgumentException("The value of a Place cannot be empty.");
        }

        if(!UtilText.isLengthValid(position,1, 10))
        {
            throw new IllegalArgumentException("The value of a Place must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.isStringAlphanumeric(position))
        {
            throw new IllegalArgumentException("The value of a Place can only contain characters.");
        }

        this.position = position;
    }
}