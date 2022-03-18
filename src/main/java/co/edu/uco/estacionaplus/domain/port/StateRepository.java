package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.State;

import java.util.List;

public interface StateRepository
{
    List<State> getAll();
    State getByCode(int code);
    boolean exists(State state);
}