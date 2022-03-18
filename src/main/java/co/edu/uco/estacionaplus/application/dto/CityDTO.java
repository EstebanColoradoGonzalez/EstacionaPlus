package co.edu.uco.estacionaplus.application.dto;

public class CityDTO
{
    private int code;
    private String name;
    private StateDTO state;

    public CityDTO()
    {

    }

    public CityDTO(int code, String name, StateDTO state)
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

    public StateDTO getState()
    {
        return state;
    }

    public void setState(StateDTO state)
    {
        this.state = state;
    }
}