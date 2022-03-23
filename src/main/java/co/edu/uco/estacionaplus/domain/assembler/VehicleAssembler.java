package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.VehicleDTO;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;

public interface VehicleAssembler extends Assembler<Vehicle, VehicleEntity, VehicleDTO>
{
    VehicleEntity assembleEntityFromDomainToSave(Vehicle domain, TypeVehicleEntity typeVehicle);
    VehicleSummaryDTO assembleSummaryDTOFromEntity(VehicleEntity entity);
    VehicleSummaryDTO assembleSummaryDTOFromDomain(Vehicle domain);
}