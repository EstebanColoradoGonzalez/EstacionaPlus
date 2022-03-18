package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class ReservedTimeEntity
{
    private int code;
    private String value;
    private String typeTime;

    public ReservedTimeEntity()
    {

    }

    public ReservedTimeEntity(int code, String value, String typeTime)
    {
        this.code = code;
        this.value = value;
        this.typeTime = typeTime;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getTypeTime()
    {
        return typeTime;
    }

    public void setTypeTime(String typeTime)
    {
        this.typeTime = typeTime;
    }
}