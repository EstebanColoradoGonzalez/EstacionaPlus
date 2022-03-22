package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TypePlaceTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var typePlace = TypePlace.create(1, "Moto");

        Assertions.assertEquals("Moto", typePlace.getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a Type of Place cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> TypePlace.create(1, null)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a Type of Place cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> TypePlace.create(1, "")).getMessage());
    }
}
