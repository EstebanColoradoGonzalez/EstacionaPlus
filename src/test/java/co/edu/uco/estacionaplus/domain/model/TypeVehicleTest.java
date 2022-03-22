package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TypeVehicleTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var typeVehicle = TypeVehicle.create(1, "Moto");

        Assertions.assertEquals("Moto", typeVehicle.getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a Type of Vehicle cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> TypeVehicle.create(1, null)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a Type of Vehicle cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> TypeVehicle.create(1, "")).getMessage());
    }
}
