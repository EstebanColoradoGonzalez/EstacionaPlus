package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.StateDTO;
import co.edu.uco.estacionaplus.domain.assembler.StateAssembler;
import co.edu.uco.estacionaplus.domain.model.State;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.StateEntity;

public class StateAssemblerImplementation implements StateAssembler
{
    private static final StateAssembler INSTANCE = new StateAssemblerImplementation();

    private StateAssemblerImplementation()
    {

    }

    public static StateAssembler getStateAssembler()
    {
        return INSTANCE;
    }

    @Override
    public State assembleDomainFromEntity(StateEntity entity)
    {
        return State.create(entity.getCode(), entity.getName());
    }

    @Override
    public StateEntity assembleEntityFromDomain(State domain)
    {
        return new StateEntity(domain.getCode(), domain.getName());
    }

    @Override
    public State assembleDomainFromDTO(StateDTO dto)
    {
        return State.create(dto.getCode(), dto.getName());
    }

    @Override
    public StateDTO assembleDTOFromDomain(State domain)
    {
        return new StateDTO(domain.getCode(), domain.getName());
    }
}