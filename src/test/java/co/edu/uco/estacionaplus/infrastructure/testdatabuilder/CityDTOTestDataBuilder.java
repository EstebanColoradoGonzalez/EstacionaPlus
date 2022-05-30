package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.CityDTO;
import co.edu.uco.estacionaplus.application.dto.StateDTO;

public class CityDTOTestDataBuilder
{
    private int code;
    private String name;
    private StateDTOTestDataBuilder state;

    public CityDTOTestDataBuilder()
    {
        this.code = 1;
        this.name = "Marinilla";
        this.state = new StateDTOTestDataBuilder();
    }

    public CityDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public CityDTOTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public CityDTO build()
    {
        return new CityDTO(code, name, state.build());
    }
}