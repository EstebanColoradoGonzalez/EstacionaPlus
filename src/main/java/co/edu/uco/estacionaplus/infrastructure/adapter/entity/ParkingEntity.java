package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class ParkingEntity
{
    private int code;
    private String nit;
    private String name;
    private String address;
    private CityEntity city;

    public ParkingEntity()
    {

    }

    public ParkingEntity(int code, String nit, String name, String address, CityEntity city)
    {
        this.code = code;
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.city = city;
    }
}