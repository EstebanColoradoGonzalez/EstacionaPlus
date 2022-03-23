package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.CityDTO;
import co.edu.uco.estacionaplus.domain.assembler.CityAssembler;
import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.CityEntity;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.StateAssemblerImplementation.getStateAssembler;

public class CityAssemblerImplementation implements CityAssembler
{
    private static final CityAssembler INSTANCE = new CityAssemblerImplementation();

    private CityAssemblerImplementation()
    {

    }

    public static CityAssembler getCityAssembler()
    {
        return INSTANCE;
    }

    @Override
    public City assembleDomainFromEntity(CityEntity entity)
    {
        return City.create(entity.getCode(), entity.getName(), getStateAssembler().assembleDomainFromEntity(entity.getState()));
    }

    @Override
    public CityEntity assembleEntityFromDomain(City domain)
    {
        return new CityEntity(domain.getCode(), domain.getName(), getStateAssembler().assembleEntityFromDomain(domain.getState()));
    }

    @Override
    public City assembleDomainFromDTO(CityDTO dto)
    {
        return City.create(dto.getCode(), dto.getName(), getStateAssembler().assembleDomainFromDTO(dto.getState()));
    }

    @Override
    public CityDTO assembleDTOFromDomain(City domain)
    {
        return new CityDTO(domain.getCode(), domain.getName(), getStateAssembler().assembleDTOFromDomain(domain.getState()));
    }
}