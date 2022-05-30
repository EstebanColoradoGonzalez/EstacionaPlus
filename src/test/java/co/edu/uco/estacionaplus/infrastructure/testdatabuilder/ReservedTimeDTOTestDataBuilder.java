package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.ReservedTimeDTO;

public class ReservedTimeDTOTestDataBuilder
{
    private int code;
    private int value;
    private String typeTime;

    public ReservedTimeDTOTestDataBuilder()
    {
        this.code = 1;
        this.value = 2;
        this.typeTime = "Hora";
    }

    public ReservedTimeDTO build()
    {
        return new ReservedTimeDTO(code, value, typeTime);
    }
}