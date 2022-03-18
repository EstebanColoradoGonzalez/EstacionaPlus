package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class TypePlaceEntity
{
    private int code;
    private String name;

    public TypePlaceEntity()
    {

    }

    public TypePlaceEntity(int code, String name)
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