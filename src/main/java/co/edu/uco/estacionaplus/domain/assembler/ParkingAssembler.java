package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.domain.model.City;
import co.edu.uco.estacionaplus.domain.model.Parking;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingEntity;

import java.util.List;

public interface ParkingAssembler extends Assembler<Parking, ParkingEntity, ParkingDTO>
{
    ParkingEntity assembleEntityFromDomainToSave(Parking domain, City city);
    ParkingEntity assembleEntityFromDomainToModify(int code, Parking domain);
    List<ParkingDTO> assembleDTOsFromDomain(List<Parking> domains);
}
