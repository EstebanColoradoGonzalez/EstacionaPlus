package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;

public class Parking
{
    private int code;
    private String nit;
    private String name;
    private String address;
    private City city;

    private Parking(int code, String nit, String name, String address, City city)
    {
        this.code = code;
        setNit(nit);
        setName(name);
        setAddress(address);
        setCity(city);
    }

    public static Parking create(int code, String nit, String name, String address, City city)
    {
        return new Parking(code, nit, name, address, city);
    }

    public int getCode()
    {
        return code;
    }

    public String getNit()
    {
        return nit;
    }

    private void setNit(String nit)
    {
        if (UtilText.isStringEmpty(nit))
        {
            throw new IllegalArgumentException("The NIT of a Parking cannot be empty.");
        }

        if(!UtilText.isLengthValid(nit,1, 20))
        {
            throw new IllegalArgumentException("The NIT of a Parking must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.stringNIT(nit))
        {
            throw new IllegalArgumentException("The NIT of a Parking can only contain characters.");
        }

        this.nit = nit;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        if (UtilText.isStringEmpty(name))
        {
            throw new IllegalArgumentException("The Name of a Parking cannot be empty.");
        }

        if(!UtilText.isLengthValid(name,1, 50))
        {
            throw new IllegalArgumentException("The Name of a Parking must have a minimum of 1 character and a maximum of 50 characters.");
        }

        if(!UtilText.isStringAlphanumeric(name))
        {
            throw new IllegalArgumentException("The Name of a Parking can only contain characters.");
        }

        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    private void setAddress(String address)
    {
        if (UtilText.isStringEmpty(address))
        {
            throw new IllegalArgumentException("The address of a Parking cannot be empty.");
        }

        if(!UtilText.isLengthValid(address,1, 50))
        {
            throw new IllegalArgumentException("The address of a Parking must have a minimum of 1 character and a maximum of 50 characters.");
        }

        if(!UtilText.isStringAlphanumeric(address))
        {
            throw new IllegalArgumentException("The address of a Parking can only contain characters and numbers.");
        }

        this.address = address;
    }

    public City getCity()
    {
        return city;
    }

    private void setCity(City city)
    {
        this.city = city;
    }
}