package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingPlaceTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);

        Assertions.assertFalse(parkingPlace.isTaken());
    }
}