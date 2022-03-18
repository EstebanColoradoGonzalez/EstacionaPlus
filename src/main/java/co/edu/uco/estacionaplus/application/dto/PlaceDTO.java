package co.edu.uco.estacionaplus.application.dto;

public class PlaceDTO
{
    private int code;
    private String position;
    private TypePlaceDTO typePlace;

    public PlaceDTO()
    {

    }

    public PlaceDTO(int code, String position, TypePlaceDTO typePlace)
    {
        this.code = code;
        this.position = position;
        this.typePlace = typePlace;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public TypePlaceDTO getTypePlace()
    {
        return typePlace;
    }

    public void setTypePlace(TypePlaceDTO typePlace)
    {
        this.typePlace = typePlace;
    }
}
