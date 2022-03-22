package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CityTest
{
    @Test
    void validateSuccessfulCreation()
    {

        var city = City.create(1, "Marinilla", State.create(1, "Antioquia"));

        Assertions.assertEquals("Marinilla",city.getName());
        Assertions.assertEquals("Antioquia",city.getState().getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a City cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> City.create(1, null, State.create(1, "Antioquia"))).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a City cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> City.create(1, "", State.create(1, "Antioquia"))).getMessage());
    }
}