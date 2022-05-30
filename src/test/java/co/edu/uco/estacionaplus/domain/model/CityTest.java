package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CityTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var state = State.create(1, "Antioquia");
        var city = City.create(1, "Marinilla", state);

        Assertions.assertEquals("Marinilla",city.getName());
        Assertions.assertEquals("Antioquia",city.getState().getName());
    }

    @Test
    void validateMissingFields()
    {
        var state = State.create(1, "Antioquia");

        Assertions.assertEquals("The name of a City cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> City.create(1, null, state)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var state = State.create(1, "Antioquia");

        Assertions.assertEquals("The name of a City cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> City.create(1, "", state)).getMessage());
    }
}