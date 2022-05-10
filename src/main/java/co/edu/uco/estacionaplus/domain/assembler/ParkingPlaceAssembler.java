package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.ParkingPlaceDTO;
import co.edu.uco.estacionaplus.domain.model.ParkingPlace;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingPlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import java.util.List;

public interface ParkingPlaceAssembler extends Assembler<ParkingPlace, ParkingPlaceEntity, ParkingPlaceDTO>
{
    List<ParkingPlace> assembleDomainsFromEntities(List<ParkingPlaceEntity> entities);
    List<ParkingPlaceEntity> assembleEntitiesFromDomains(List<ParkingPlace> domains);
    List<ParkingPlaceDTO> assembleDTOsFromDomains(List<ParkingPlace> domains);
    List<ParkingPlace> assembleDomainsFromDTOs(List<ParkingPlaceDTO> dtos);
    ParkingPlaceEntity assembleEntityFromDomainToSave(ParkingPlace domain, PlaceEntity place);
    ParkingPlaceEntity assembleEntityFromDomainToModify(int code, ParkingPlace domain);
    ParkingPlace assembleDomainFromDTOToModify(ParkingPlaceDTO dto, boolean taken);
}
