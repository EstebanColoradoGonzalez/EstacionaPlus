package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.PriceDTO;

public class PriceDTOTestDataBuilder
{
    private int code;
    private double value;

    public PriceDTOTestDataBuilder(int code, double value)
    {
        this.code = 1;
        this.value = 4000;
    }

    public PriceDTO build()
    {
        return new PriceDTO(code, value);
    }
}