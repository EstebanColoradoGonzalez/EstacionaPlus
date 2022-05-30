package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.TypePlaceDTO;

public class TypePlaceDTOTestDataBuilder
{
    private int code;
    private String name;

    public TypePlaceDTOTestDataBuilder(int code, String name)
    {
        this.code = 1;
        this.name = "Motocicleta";
    }

    public TypePlaceDTO build()
    {
        return new TypePlaceDTO(code, name);
    }
}