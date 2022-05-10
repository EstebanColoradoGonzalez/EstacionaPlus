package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
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
    private List<ParkingPlace> places;

    private Parking(int code, String nit, String name, String address, City city, List<ParkingPlace> places)
    {
        this.code = code;
        setNit(nit);
        setName(name);
        setAddress(address);
        this.city = city;
        this.places = places;
    }

    public static Parking create(int code, String nit, String name, String address, City city, List<ParkingPlace> places)
    {
        return new Parking(code, nit, name, address, city, places);
    }

    private void setNit(String nit)
    {
        if (ValidateString.isStringEmpty(nit))
        {
            throw new IllegalArgumentException(Message.PARKING_NIT_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(nit,1, 20))
        {
            throw new IllegalArgumentException(Message.PARKING_NIT_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringNIT(nit))
        {
            throw new IllegalArgumentException(Message.PARKING_NIT_CHECK_PATTERN);
        }

        this.nit = nit;
    }

    private void setName(String name)
    {
        if (ValidateString.isStringEmpty(name))
        {
            throw new IllegalArgumentException(Message.PARKING_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(name,1, 50))
        {
            throw new IllegalArgumentException(Message.PARKING_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException(Message.PARKING_NAME_CHECK_PATTERN);
        }

        this.name = name;
    }

    private void setAddress(String address)
    {
        if (ValidateString.isStringEmpty(address))
        {
            throw new IllegalArgumentException(Message.PARKING_ADDRESS_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(address,1, 50))
        {
            throw new IllegalArgumentException(Message.PARKING_ADDRESS_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(address))
        {
            throw new IllegalArgumentException(Message.PARKING_ADDRESS_CHECK_PATTERN);
        }

        this.address = address;
    }
}