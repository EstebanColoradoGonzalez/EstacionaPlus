package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriceTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var price = Price.create(1, 5000);

        Assertions.assertEquals(5000, price.getValue());
    }
}
