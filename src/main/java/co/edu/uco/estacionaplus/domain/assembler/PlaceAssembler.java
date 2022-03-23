package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.PlaceDTO;
import co.edu.uco.estacionaplus.domain.model.Place;
import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;

import java.util.List;

public interface PlaceAssembler extends Assembler<Place, PlaceEntity, PlaceDTO>
{
    List<Place> assembleDomainsFromEntities(List<PlaceEntity> entities);
    List<PlaceEntity> assembleEntitiesFromDomains(List<Place> domains);
    List<PlaceDTO> assembleDTOsFromDomains(List<Place> domains);
    List<Place> assembleDomainsFromDTOs(List<PlaceDTO> dtos);
    PlaceEntity assembleEntityFromDomainToSave(Place domain, TypePlace typePlace);
    PlaceEntity assembleEntityFromDomainToModify(int code, Place domain);
}