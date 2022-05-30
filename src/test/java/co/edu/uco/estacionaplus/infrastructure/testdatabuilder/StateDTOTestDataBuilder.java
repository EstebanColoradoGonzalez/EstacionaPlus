package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.StateDTO;

public class StateDTOTestDataBuilder
{
    private int code;
    private String name;

    public StateDTOTestDataBuilder()
    {
        this.code = 1;
        this.name = "Antioquia";
    }

    public StateDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public StateDTOTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public StateDTO build()
    {
        return new StateDTO(code, name);
    }
}