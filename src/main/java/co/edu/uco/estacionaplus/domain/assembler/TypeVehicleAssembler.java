package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.TypeVehicleDTO;
import co.edu.uco.estacionaplus.domain.dto.TypeVehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;

public interface TypeVehicleAssembler extends Assembler<TypeVehicle, TypeVehicleEntity, TypeVehicleDTO>
{
    TypeVehicleSummaryDTO assembleSummaryDTOFromEntity(TypeVehicleEntity entity);
    TypeVehicleSummaryDTO assembleSummaryDTOFromDomain(TypeVehicle domain);
}