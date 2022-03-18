package co.edu.uco.estacionaplus.application.dto;

public class PriceDTO
{
    private int code;
    private double value;

    public PriceDTO()
    {

    }

    public PriceDTO(int code, double value)
    {
        this.code = code;
        this.value = value;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }
}