package co.edu.uco.estacionaplus.domain.dto;

public class VehicleSummaryDTO
{
    private int code;
    private String license;
    private TypeVehicleSummaryDTO typeVehicle;

    public VehicleSummaryDTO()
    {

    }

    public VehicleSummaryDTO(int code, String license, TypeVehicleSummaryDTO typeVehicle)
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

    public TypeVehicleSummaryDTO getTypeVehicle()
    {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicleSummaryDTO typeVehicle)
    {
        this.typeVehicle = typeVehicle;
    }
}