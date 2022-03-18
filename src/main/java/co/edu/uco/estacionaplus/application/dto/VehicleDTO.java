package co.edu.uco.estacionaplus.application.dto;

public class VehicleDTO
{
    private int code;
    private String license;
    private TypeVehicleDTO typeVehicle;

    public VehicleDTO()
    {

    }

    public VehicleDTO(int code, String license, TypeVehicleDTO typeVehicle)
    {
        this.code = code;
        this.license = license;
        this.typeVehicle = typeVehicle;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    public TypeVehicleDTO getTypeVehicle()
    {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicleDTO typeVehicle)
    {
        this.typeVehicle = typeVehicle;
    }
}