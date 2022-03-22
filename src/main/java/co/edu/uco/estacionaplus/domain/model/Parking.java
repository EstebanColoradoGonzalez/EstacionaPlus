package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;
import java.util.List;

@Getter
public class Parking
{
    private int code;
    private String nit;
    private String name;
    private String address;
    private City city;
    private List<Place> places;

    private Parking(int code, String nit, String name, String address, City city, List<Place> places)
    {
        this.code = code;
        setNit(nit);
        setName(name);
        setAddress(address);
        this.city = city;
        this.places = places;
    }

    public static Parking create(int code, String nit, String name, String address, City city, List<Place> places)
    {
        return new Parking(code, nit, name, address, city, places);
    }

    private void setNit(String nit)
    {
        if (UtilText.isStringEmpty(nit))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NIT_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(nit,1, 20))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NIT_CHECK_LENGTH_VALID);
        }

        if(!UtilText.stringNIT(nit))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NIT_CHECK_PATTERN);
        }

        this.nit = nit;
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NAME_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(name,1, 50))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NAME_CHECK_LENGTH_VALID);
        }

        if(!UtilText.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }

    private void setAddress(String address)
    {
        if (UtilText.isStringEmpty(address))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_ADDRESS_CHECK_STRING_EMPTY);
        }

        if(!UtilText.isLengthValid(address,1, 50))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_ADDRESS_CHECK_LENGTH_VALID);
        }

        if(!UtilText.isStringAlphanumeric(address))
        {
            throw new IllegalArgumentException(UtilMessage.PARKING_ADDRESS_CHECK_PATTERN);
        }

        this.address = address;
    }
}