package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaymentMethodTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var paymentMethod = PaymentMethod.create(1, "Tarjeta");

        Assertions.assertEquals("Tarjeta", paymentMethod.getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a Payment Method cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> PaymentMethod.create(1, null)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a Payment Method cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> PaymentMethod.create(1, "")).getMessage());
    }
}
