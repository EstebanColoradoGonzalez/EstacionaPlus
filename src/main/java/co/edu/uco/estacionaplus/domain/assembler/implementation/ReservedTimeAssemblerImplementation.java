package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.ReservedTimeDTO;
import co.edu.uco.estacionaplus.domain.assembler.ReservedTimeAssembler;
import co.edu.uco.estacionaplus.domain.model.ReservedTime;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservedTimeEntity;

public class ReservedTimeAssemblerImplementation implements ReservedTimeAssembler
{
    private static final ReservedTimeAssembler INSTANCE = new ReservedTimeAssemblerImplementation();

    private ReservedTimeAssemblerImplementation()
    {

    }

    public static ReservedTimeAssembler getReservedTimeAssembler()
    {
        return INSTANCE;
    }

    @Override
    public ReservedTime assembleDomainFromEntity(ReservedTimeEntity entity)
    {
        return ReservedTime.create(entity.getCode(), entity.getValue(), entity.getTypeTime());
    }

    @Override
    public ReservedTimeEntity assembleEntityFromDomain(ReservedTime domain)
    {
        return new ReservedTimeEntity(domain.getCode(), domain.getValue(), domain.getTypeTime());
    }

    @Override
    public ReservedTime assembleDomainFromDTO(ReservedTimeDTO dto)
    {
        return ReservedTime.create(dto.getCode(), dto.getValue(), dto.getTypeTime());
    }

    @Override
    public ReservedTimeDTO assembleDTOFromDomain(ReservedTime domain)
    {
        return new ReservedTimeDTO(domain.getCode(), domain.getValue(), domain.getTypeTime());
    }
}