package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class PaymentMethodEntity
{
    private int code;
    private String name;

    public PaymentMethodEntity()
    {

    }

    public PaymentMethodEntity(int code, String name)
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