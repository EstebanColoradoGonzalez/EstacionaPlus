package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.TypePlaceDTO;
import co.edu.uco.estacionaplus.domain.assembler.TypePlaceAssembler;
import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypePlaceEntity;

public class TypePlaceAssemblerImplementation implements TypePlaceAssembler
{
    private static final TypePlaceAssembler INSTANCE = new TypePlaceAssemblerImplementation();

    private TypePlaceAssemblerImplementation()
    {

    }

    public static TypePlaceAssembler getTypePlaceAssembler()
    {
        return INSTANCE;
    }

    @Override
    public TypePlace assembleDomainFromEntity(TypePlaceEntity entity)
    {
        return TypePlace.create(entity.getCode(), entity.getName());
    }

    @Override
    public TypePlaceEntity assembleEntityFromDomain(TypePlace domain)
    {
        return new TypePlaceEntity(domain.getCode(), domain.getName());
    }

    @Override
    public TypePlace assembleDomainFromDTO(TypePlaceDTO dto)
    {
        return TypePlace.create(dto.getCode(), dto.getName());
    }

    @Override
    public TypePlaceDTO assembleDTOFromDomain(TypePlace domain)
    {
        return new TypePlaceDTO(domain.getCode(), domain.getName());
    }
}