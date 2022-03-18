package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class PlaceEntity
{
    private int code;
    private String position;
    private TypePlaceEntity typePlace;

    public PlaceEntity()
    {

    }

    public PlaceEntity(int code, String position, TypePlaceEntity typePlace)
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

    public TypePlaceEntity getTypePlace()
    {
        return typePlace;
    }

    public void setTypePlace(TypePlaceEntity typePlace)
    {
        this.typePlace = typePlace;
    }
}
