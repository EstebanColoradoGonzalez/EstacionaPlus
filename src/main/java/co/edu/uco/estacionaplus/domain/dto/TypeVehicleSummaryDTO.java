package co.edu.uco.estacionaplus.domain.dto;

public class TypeVehicleSummaryDTO
{
    private int code;
    private String name;

    public TypeVehicleSummaryDTO()
    {

    }

    public TypeVehicleSummaryDTO(int code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}