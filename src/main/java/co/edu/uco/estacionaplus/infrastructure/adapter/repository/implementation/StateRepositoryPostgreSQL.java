package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.State;
import co.edu.uco.estacionaplus.domain.port.StateRepository;
import co.edu.uco.estacionaplus.domain.validator.ValidateObject;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.StateDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.StateAssemblerImplementation.getStateAssembler;

@Repository
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
        return this.stateDAO.findAll().stream().map(getStateAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public State getByCode(int code)
    {
        return this.stateDAO.findById(code).map(getStateAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public State getByName(String name)
    {
        var state = this.stateDAO.findByName(name);

        if(ValidateObject.isNull(state))
        {
            return null;
        }

        return getStateAssembler().assembleDomainFromEntity(state);
    }

    @Override
    public boolean exists(State state)
    {
        return this.stateDAO.existsById(state.getCode());
    }
}