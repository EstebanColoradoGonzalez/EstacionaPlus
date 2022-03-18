package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservedTimeTest
{
    @Test
    void validateSuccessfulCreation()
    {

        var reservedTime = ReservedTime.create(1, "2", "Horas");

        Assertions.assertEquals("2", reservedTime.getValue());
        Assertions.assertEquals("Horas", reservedTime.getTypeTime());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The value of a ReservedTime cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> ReservedTime.create(1, null, "Horas")).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The value of a ReservedTime cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> ReservedTime.create(1, "", "Horas")).getMessage());
    }
}
