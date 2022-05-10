package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.ReservedTimeDTO;
import co.edu.uco.estacionaplus.domain.model.ReservedTime;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservedTimeEntity;

public interface ReservedTimeAssembler extends Assembler<ReservedTime, ReservedTimeEntity, ReservedTimeDTO>
{
}