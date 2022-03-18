package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var state = State.create(1, "Antioquia");

        Assertions.assertEquals("Antioquia", state.getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a State cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> State.create(1, null)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a State cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> State.create(1, "")).getMessage());
    }
}