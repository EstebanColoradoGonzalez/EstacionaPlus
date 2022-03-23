package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.StateDTO;
import co.edu.uco.estacionaplus.domain.model.State;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.StateEntity;

public interface StateAssembler extends Assembler<State, StateEntity, StateDTO>
{

}