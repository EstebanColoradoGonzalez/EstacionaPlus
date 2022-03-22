package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ParkingTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var places = new ArrayList<Place>();

        places.add(Place.create(1, "A1", true, TypePlace.create(1, "Motocicleta")));

        var parking = Parking.create(1, "888888888-3", "Parqueadero", "Calle 35 Numero 33 135", City.create(1, "Marinilla", State.create(1, "Antioquia")), places);

        Assertions.assertEquals("888888888-3",parking.getNit());
        Assertions.assertEquals("Parqueadero",parking.getName());
        Assertions.assertEquals("Calle 35 Numero 33 135",parking.getAddress());
        Assertions.assertEquals("Marinilla",parking.getCity().getName());
        Assertions.assertEquals("Antioquia",parking.getCity().getState().getName());
    }

    @Test
    void validateMissingFields()
    {
        var places = new ArrayList<Place>();

        places.add(Place.create(1, "A1", true, TypePlace.create(1, "Motocicleta")));

        Assertions.assertEquals("The Name of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "888888888-3", null, "Calle 35 # 33 - 135", City.create(1, "Marinilla", State.create(1, "Antioquia")), places)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var places = new ArrayList<Place>();

        places.add(Place.create(1, "A1", true, TypePlace.create(1, "Motocicleta")));

        Assertions.assertEquals("The Name of a Parking cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "888888888-3", "", "Calle 35 # 33 - 135", City.create(1, "Marinilla", State.create(1, "Antioquia")), places)).getMessage());
    }
}