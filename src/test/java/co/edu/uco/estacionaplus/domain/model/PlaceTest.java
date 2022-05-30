package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);

        Assertions.assertEquals("A1", place.getPosition());
    }

    @Test
    void validateMissingFields()
    {
        var typePlace = TypePlace.create(1, "Moto");

        Assertions.assertEquals("The value of a Place cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Place.create(1, null, typePlace)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var typePlace = TypePlace.create(1, "Moto");

        Assertions.assertEquals("The value of a Place cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Place.create(1, "", typePlace)).getMessage());
    }
}