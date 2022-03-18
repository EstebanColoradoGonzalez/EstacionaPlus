package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceTest
{
    @Test
    void validateSuccessfulCreation()
    {

        var place = Place.create(1, "A1", TypePlace.create(1, "Moto"));

        Assertions.assertEquals("A1", place.getPosition());
        Assertions.assertEquals("Moto", place.getTypePlace().getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The value of a Place cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Place.create(1, null, TypePlace.create(1, "Moto"))).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The value of a Place cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Place.create(1, "", TypePlace.create(1, "Moto"))).getMessage());
    }
}
