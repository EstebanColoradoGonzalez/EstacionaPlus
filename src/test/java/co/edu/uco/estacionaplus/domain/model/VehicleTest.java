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
        var typeVehicle = TypeVehicle.create(1, "Moto");

        Assertions.assertEquals("The license of a Vehicle cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Vehicle.create(1, null, typeVehicle)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var typeVehicle = TypeVehicle.create(1, "Moto");

        Assertions.assertEquals("The license of a Vehicle cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Vehicle.create(1, "", typeVehicle)).getMessage());
    }
}