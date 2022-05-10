package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.ParkingPlaceDTO;
import co.edu.uco.estacionaplus.domain.assembler.ParkingPlaceAssembler;
import co.edu.uco.estacionaplus.domain.model.ParkingPlace;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingPlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;

public class ParkingPlaceAssemblerImplementation implements ParkingPlaceAssembler
{
    private static final ParkingPlaceAssembler INSTANCE = new ParkingPlaceAssemblerImplementation();

    private ParkingPlaceAssemblerImplementation()
    {

    }

    public static ParkingPlaceAssembler getParkingPlaceAssembler()
    {
        return INSTANCE;
    }

    @Override
    public ParkingPlace assembleDomainFromEntity(ParkingPlaceEntity entity)
    {
        return ParkingPlace.create(entity.getCode(), entity.isTaken(), getPlaceAssembler().assembleDomainFromEntity(entity.getPlace()));
    }

    @Override
    public ParkingPlaceEntity assembleEntityFromDomain(ParkingPlace domain)
    {
        return new ParkingPlaceEntity(domain.getCode(), domain.isTaken(), getPlaceAssembler().assembleEntityFromDomain(domain.getPlace()));
    }

    @Override
    public ParkingPlace assembleDomainFromDTO(ParkingPlaceDTO dto)
    {
        return ParkingPlace.create(dto.getCode(), dto.isTaken(), getPlaceAssembler().assembleDomainFromDTO(dto.getPlace()));
    }

    @Override
    public ParkingPlaceDTO assembleDTOFromDomain(ParkingPlace domain)
    {
        return new ParkingPlaceDTO(domain.getCode(), domain.isTaken(), getPlaceAssembler().assembleDTOFromDomain(domain.getPlace()));
    }

    @Override
    public List<ParkingPlace> assembleDomainsFromEntities(List<ParkingPlaceEntity> entities)
    {
        return entities.stream().map(this::assembleDomainFromEntity).toList();
    }

    @Override
    public List<ParkingPlaceEntity> assembleEntitiesFromDomains(List<ParkingPlace> domains)
    {
        return domains.stream().map(this::assembleEntityFromDomain).toList();
    }

    @Override
    public List<ParkingPlaceDTO> assembleDTOsFromDomains(List<ParkingPlace> domains)
    {
        return domains.stream().map(this::assembleDTOFromDomain).toList();
    }

    @Override
    public List<ParkingPlace> assembleDomainsFromDTOs(List<ParkingPlaceDTO> dtos)
    {
        return dtos.stream().map(this::assembleDomainFromDTO).toList();
    }

    @Override
    public ParkingPlaceEntity assembleEntityFromDomainToSave(ParkingPlace domain, PlaceEntity place)
    {
        return new ParkingPlaceEntity(domain.getCode(), domain.isTaken(), place);
    }

    @Override
    public ParkingPlaceEntity assembleEntityFromDomainToModify(int code, ParkingPlace domain)
    {
        return new ParkingPlaceEntity(code, domain.isTaken(), getPlaceAssembler().assembleEntityFromDomain(domain.getPlace()));
    }

    @Override
    public ParkingPlace assembleDomainFromDTOToModify(ParkingPlaceDTO dto, boolean taken)
    {
        return ParkingPlace.create(dto.getCode(), taken, getPlaceAssembler().assembleDomainFromDTO(dto.getPlace()));
    }
}