package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var vehicle = Vehicle.create(1, "USV36D", TypeVehicle.create(1, "Moto"));

        Assertions.assertEquals("USV36D", vehicle.getLicense());
        Assertions.assertEquals("Moto", vehicle.getTypeVehicle().getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The license of a Vehicle cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Vehicle.create(1, null, TypeVehicle.create(1, "Moto"))).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The license of a Vehicle cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Vehicle.create(1, "", TypeVehicle.create(1, "Moto"))).getMessage());
    }
}