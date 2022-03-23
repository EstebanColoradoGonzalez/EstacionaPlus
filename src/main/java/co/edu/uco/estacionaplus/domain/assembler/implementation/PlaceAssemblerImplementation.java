package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.PlaceDTO;
import co.edu.uco.estacionaplus.domain.assembler.PlaceAssembler;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.TypePlaceAssemblerImplementation.getTypePlaceAssembler;

public class PlaceAssemblerImplementation implements PlaceAssembler
{
    private static final PlaceAssembler INSTANCE = new PlaceAssemblerImplementation();

    private PlaceAssemblerImplementation()
    {

    }

    public static PlaceAssembler getPlaceAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Place assembleDomainFromEntity(PlaceEntity entity)
    {
        return Place.create(entity.getCode(), entity.getPosition(), entity.isTaken(), getTypePlaceAssembler().assembleDomainFromEntity(entity.getTypePlace()));
    }

    @Override
    public PlaceEntity assembleEntityFromDomain(Place domain)
    {
        return new PlaceEntity(domain.getCode(), domain.getPosition(), domain.isTaken(), getTypePlaceAssembler().assembleEntityFromDomain(domain.getTypePlace()));
    }

    @Override
    public Place assembleDomainFromDTO(PlaceDTO dto)
    {
        return Place.create(dto.getCode(), dto.getPosition(), dto.isTaken(), getTypePlaceAssembler().assembleDomainFromDTO(dto.getTypePlace()));
    }

    @Override
    public PlaceDTO assembleDTOFromDomain(Place domain)
    {
        return new PlaceDTO(domain.getCode(), domain.getPosition(), domain.isTaken(), getTypePlaceAssembler().assembleDTOFromDomain(domain.getTypePlace()));
    }

    @Override
    public List<Place> assembleDomainsFromEntities(List<PlaceEntity> entities)
    {
        return entities.stream().map(getPlaceAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public List<PlaceEntity> assembleEntitiesFromDomains(List<Place> domains)
    {
        return domains.stream().map(getPlaceAssembler()::assembleEntityFromDomain).toList();
    }

    @Override
    public List<PlaceDTO> assembleDTOsFromDomains(List<Place> domains)
    {
        return domains.stream().map(getPlaceAssembler()::assembleDTOFromDomain).toList();
    }

    @Override
    public List<Place> assembleDomainsFromDTOs(List<PlaceDTO> dtos)
    {
        return dtos.stream().map(getPlaceAssembler()::assembleDomainFromDTO).toList();
    }

    @Override
    public PlaceEntity assembleEntityFromDomainToSave(Place domain, TypePlace typePlace)
    {
        return new PlaceEntity(domain.getCode(), domain.getPosition(), domain.isTaken(), getTypePlaceAssembler().assembleEntityFromDomain(typePlace));
    }

    @Override
    public PlaceEntity assembleEntityFromDomainToModify(int code, Place domain)
    {
        return new PlaceEntity(code, domain.getPosition(), domain.isTaken(), getTypePlaceAssembler().assembleEntityFromDomain(domain.getTypePlace()));
    }
}