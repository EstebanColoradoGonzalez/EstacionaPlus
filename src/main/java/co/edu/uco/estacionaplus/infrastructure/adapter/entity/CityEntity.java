package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class CityEntity
{
    private int code;
    private String name;
    private StateEntity state;

    public CityEntity()
    {

    }

    public CityEntity(int code, String name, StateEntity state)
    {
        this.code = code;
        this.name = name;
        this.state = state;
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

    public StateEntity getState()
    {
        return state;
    }

    public void setState(StateEntity state)
    {
        this.state = state;
    }
}