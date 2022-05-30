package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ParkingTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);
        List<ParkingPlace> places = new ArrayList<>();
        places.add(parkingPlace);
        var state = State.create(1, "Antioquia");
        var city = City.create(1, "Marinilla", state);
        var parking = Parking.create(1, "11111111-1", "UCO", "Calle 45", city, places);

        Assertions.assertEquals("11111111-1", parking.getNit());
        Assertions.assertEquals("UCO", parking.getName());
        Assertions.assertEquals("Calle 45", parking.getAddress());
    }

    @Test
    void validateMissingFields()
    {
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);
        List<ParkingPlace> places = new ArrayList<>();
        places.add(parkingPlace);
        var state = State.create(1, "Antioquia");
        var city = City.create(1, "Marinilla", state);

        Assertions.assertEquals("The NIT of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, null, "UCO", "Calle 45", city, places)).getMessage());
        Assertions.assertEquals("The Name of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "11111111-1", null, "Calle 45", city, places)).getMessage());
        Assertions.assertEquals("The address of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "11111111-1", "UCO", null, city, places)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);
        List<ParkingPlace> places = new ArrayList<>();
        places.add(parkingPlace);
        var state = State.create(1, "Antioquia");
        var city = City.create(1, "Marinilla", state);

        Assertions.assertEquals("The NIT of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "", "UCO", "Calle 45", city, places)).getMessage());
        Assertions.assertEquals("The Name of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "11111111-1", "", "Calle 45", city, places)).getMessage());
        Assertions.assertEquals("The address of a Parking cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Parking.create(1, "11111111-1", "UCO", "", city, places)).getMessage());
    }
}
