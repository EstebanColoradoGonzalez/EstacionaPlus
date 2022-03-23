package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.VehicleDTO;
import co.edu.uco.estacionaplus.domain.assembler.VehicleAssembler;
import co.edu.uco.estacionaplus.domain.dto.VehicleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.TypeVehicleAssemblerImplementation.getTypeVehicleAssembler;

public class VehicleAssemblerImplementation implements VehicleAssembler
{
    private static final VehicleAssembler INSTANCE = new VehicleAssemblerImplementation();

    private VehicleAssemblerImplementation()
    {

    }

    public static VehicleAssembler getVehicleAssembler()
    {
        return INSTANCE;
    }

    @Override
    public Vehicle assembleDomainFromEntity(VehicleEntity entity)
    {
        return Vehicle.create(entity.getCode(), entity.getLicense(), getTypeVehicleAssembler().assembleDomainFromEntity(entity.getTypeVehicle()));
    }

    @Override
    public VehicleEntity assembleEntityFromDomain(Vehicle domain)
    {
        return new VehicleEntity(domain.getCode(), domain.getLicense(), getTypeVehicleAssembler().assembleEntityFromDomain(domain.getTypeVehicle()));
    }

    @Override
    public Vehicle assembleDomainFromDTO(VehicleDTO dto)
    {
        return Vehicle.create(dto.getCode(), dto.getLicense(), getTypeVehicleAssembler().assembleDomainFromDTO(dto.getTypeVehicle()));
    }

    @Override
    public VehicleDTO assembleDTOFromDomain(Vehicle domain)
    {
        return new VehicleDTO(domain.getCode(), domain.getLicense(), getTypeVehicleAssembler().assembleDTOFromDomain(domain.getTypeVehicle()));
    }

    @Override
    public VehicleEntity assembleEntityFromDomainToSave(Vehicle domain, TypeVehicleEntity typeVehicle)
    {
        return new VehicleEntity(domain.getCode(), domain.getLicense(), typeVehicle);
    }

    @Override
    public VehicleSummaryDTO assembleSummaryDTOFromEntity(VehicleEntity entity)
    {
        return new VehicleSummaryDTO(entity.getCode(), entity.getLicense(), getTypeVehicleAssembler().assembleSummaryDTOFromEntity(entity.getTypeVehicle()));
    }

    @Override
    public VehicleSummaryDTO assembleSummaryDTOFromDomain(Vehicle domain)
    {
        return new VehicleSummaryDTO(domain.getCode(), domain.getLicense(), getTypeVehicleAssembler().assembleSummaryDTOFromDomain(domain.getTypeVehicle()));
    }
}