package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.State;
import co.edu.uco.estacionaplus.domain.port.StateRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.StateEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.StateDAO;
import java.util.List;

public class StateRepositoryPostgreSQL implements StateRepository
{
    private final StateDAO stateDAO;

    public StateRepositoryPostgreSQL(StateDAO stateDAO)
    {
        this.stateDAO = stateDAO;
    }

    @Override
    public List<State> getAll()
    {
        return this.stateDAO.findAll().stream().map(this::assembleState).toList();
    }

    @Override
    public State getByCode(int code)
    {
        return this.stateDAO.findById(code).map(this::assembleState).orElse(null);
    }

    @Override
    public State getByName(String name)
    {
        var state = this.stateDAO.findByName(name);

        if(UtilObject.isNull(state))
        {
            return null;
        }

        return assembleState(state);
    }

    @Override
    public boolean exists(State state)
    {
        return this.stateDAO.existsById(state.getCode());
    }

    private State assembleState(StateEntity state)
    {
        return State.create(state.getCode(), state.getName());
    }
}