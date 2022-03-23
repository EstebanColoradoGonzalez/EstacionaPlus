package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.TypeVehicleDTO;
import co.edu.uco.estacionaplus.domain.assembler.TypeVehicleAssembler;
import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;

public class TypeVehicleAssemblerImplementation implements TypeVehicleAssembler
{
    private static final TypeVehicleAssembler INSTANCE = new TypeVehicleAssemblerImplementation();

    private TypeVehicleAssemblerImplementation()
    {

    }

    public static TypeVehicleAssembler getTypeVehicleAssembler()
    {
        return INSTANCE;
    }

    @Override
    public TypeVehicle assembleDomainFromEntity(TypeVehicleEntity entity)
    {
        return TypeVehicle.create(entity.getCode(), entity.getName());
    }

    @Override
    public TypeVehicleEntity assembleEntityFromDomain(TypeVehicle domain)
    {
        return new TypeVehicleEntity(domain.getCode(), domain.getName());
    }

    @Override
    public TypeVehicle assembleDomainFromDTO(TypeVehicleDTO dto)
    {
        return TypeVehicle.create(dto.getCode(), dto.getName());
    }

    @Override
    public TypeVehicleDTO assembleDTOFromDomain(TypeVehicle domain)
    {
        return new TypeVehicleDTO(domain.getCode(), domain.getName());
    }

    @Override
    public TypeVehicleSummaryDTO assembleSummaryDTOFromEntity(TypeVehicleEntity entity)
    {
        return new TypeVehicleSummaryDTO(entity.getCode(), entity.getName());
    }

    @Override
    public TypeVehicleSummaryDTO assembleSummaryDTOFromDomain(TypeVehicle domain)
    {
        return new TypeVehicleSummaryDTO(domain.getCode(), domain.getName());
    }
}