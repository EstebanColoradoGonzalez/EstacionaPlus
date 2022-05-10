package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.Getter;

@Getter
public class Place
{
    private int code;
    private String position;
    private TypePlace typePlace;

    private Place(int code, String position, TypePlace typePlace)
    {
        this.code = code;
        setPosition(position);
        this.typePlace = typePlace;
    }

    public static Place create(int code, String position, TypePlace typePlace)
    {
        return new Place(code, position, typePlace);
    }

    private void setPosition(String position)
    {
        if (ValidateString.isStringEmpty(position))
        {
            throw new IllegalArgumentException(Message.PLACE_POSITION_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(position,1, 10))
        {
            throw new IllegalArgumentException(Message.PLACE_POSITION_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(position))
        {
            throw new IllegalArgumentException(Message.PLACE_POSITION_CHECK_PATTERN);
        }

        this.position = position;
    }
}