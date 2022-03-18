package co.edu.uco.estacionaplus.application.dto;

public class ParkingDTO
{
    private int code;
    private String nit;
    private String name;
    private String address;
    private CityDTO city;

    public ParkingDTO()
    {

    }

    public ParkingDTO(int code, String nit, String name, String address, CityDTO city)
    {
        this.code = code;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.city = city;
    }
}