package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.domain.assembler.ParkingAssembler;
import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.domain.model.Parking;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingEntity;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.CityAssemblerImplementation.getCityAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.PlaceAssemblerImplementation.getPlaceAssembler;

public class ParkingAssemblerImplementation implements ParkingAssembler
{
    private static final ParkingAssembler INSTANCE = new ParkingAssemblerImplementation();

    private ParkingAssemblerImplementation()
    {

    }

    public static ParkingAssembler getParkingAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Parking assembleDomainFromEntity(ParkingEntity entity)
    {
        return Parking.create(entity.getCode(), entity.getNit(), entity.getName(), entity.getAddress(), getCityAssembler().assembleDomainFromEntity(entity.getCity()), getPlaceAssembler().assembleDomainsFromEntities(entity.getPlaces()));
    }

    @Override
    public ParkingEntity assembleEntityFromDomain(Parking domain)
    {
        return new ParkingEntity(domain.getCode(), domain.getNit(), domain.getName(), domain.getAddress(), getCityAssembler().assembleEntityFromDomain(domain.getCity()), getPlaceAssembler().assembleEntitiesFromDomains(domain.getPlaces()));
    }

    @Override
    public Parking assembleDomainFromDTO(ParkingDTO dto)
    {
        return Parking.create(dto.getCode(), dto.getNit(), dto.getName(), dto.getAddress(), getCityAssembler().assembleDomainFromDTO(dto.getCity()), getPlaceAssembler().assembleDomainsFromDTOs(dto.getPlaces()));
    }

    @Override
    public ParkingDTO assembleDTOFromDomain(Parking domain)
    {
        return new ParkingDTO(domain.getCode(), domain.getNit(), domain.getName(), domain.getAddress(), getCityAssembler().assembleDTOFromDomain(domain.getCity()), getPlaceAssembler().assembleDTOsFromDomains(domain.getPlaces()));
    }

    @Override
    public ParkingEntity assembleEntityFromDomainToSave(Parking domain, City city) {
        return new ParkingEntity(domain.getCode(), domain.getNit(), domain.getName(), domain.getAddress(), getCityAssembler().assembleEntityFromDomain(city), getPlaceAssembler().assembleEntitiesFromDomains(domain.getPlaces()));
    }

    @Override
    public ParkingEntity assembleEntityFromDomainToModify(int code, Parking domain) {
        return new ParkingEntity(code, domain.getNit(), domain.getName(), domain.getAddress(), getCityAssembler().assembleEntityFromDomain(domain.getCity()), getPlaceAssembler().assembleEntitiesFromDomains(domain.getPlaces()));
    }

    @Override
    public List<ParkingDTO> assembleDTOsFromDomain(List<Parking> domains)
    {
        return domains.stream().map(this::assembleDTOFromDomain).toList();
    }
}