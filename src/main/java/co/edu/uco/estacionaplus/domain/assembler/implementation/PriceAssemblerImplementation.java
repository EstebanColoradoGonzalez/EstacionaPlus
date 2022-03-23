package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.PriceDTO;
import co.edu.uco.estacionaplus.domain.assembler.PriceAssembler;
import co.edu.uco.estacionaplus.domain.model.Price;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PriceEntity;

public class PriceAssemblerImplementation implements PriceAssembler
{
    private static final PriceAssembler INSTANCE = new PriceAssemblerImplementation();

    private PriceAssemblerImplementation()
    {

    }

    public static PriceAssembler getPriceAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Price assembleDomainFromEntity(PriceEntity entity)
    {
        return Price.create(entity.getCode(), entity.getValue());
    }

    @Override
    public PriceEntity assembleEntityFromDomain(Price domain)
    {
        return new PriceEntity(domain.getCode(), domain.getValue());
    }

    @Override
    public Price assembleDomainFromDTO(PriceDTO dto)
    {
        return Price.create(dto.getCode(), dto.getValue());
    }

    @Override
    public PriceDTO assembleDTOFromDomain(Price domain)
    {
        return new PriceDTO(domain.getCode(), domain.getValue());
    }
}