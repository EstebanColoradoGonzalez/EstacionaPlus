package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserParkingTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var userRole = UserRole.create(1, "ROLE_USER");
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRole);
        var typeVehicle = TypeVehicle.create(1, "Moto");
        var vehicle = Vehicle.create(1, "USV36D", typeVehicle);
        var user = User.create(1, "Esteban", "Colorado González", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle);

        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);
        List<ParkingPlace> places = new ArrayList<>();
        places.add(parkingPlace);
        var state = State.create(1, "Antioquia");
        var city = City.create(1, "Marinilla", state);
        var parking = Parking.create(1, "11111111-1", "UCO", "Calle 45", city, places);

        var userParking = UserParking.create(1, user, parking);

        Assertions.assertEquals("Esteban", userParking.getUser().getNames());
        Assertions.assertEquals("Colorado González", userParking.getUser().getLastNames());
        Assertions.assertEquals("1038418594", userParking.getUser().getIdentificationNumber());
        Assertions.assertEquals("3228486049", userParking.getUser().getPhone());
        Assertions.assertEquals("estebancoloradogonzalez@gmail.com", userParking.getUser().getEmail());
        Assertions.assertEquals("123456789Aa", userParking.getUser().getPassword());
        Assertions.assertEquals("ROLE_USER", userParking.getUser().getRoles().get(0).getName());
        Assertions.assertEquals("USV36D", userParking.getUser().getVehicle().getLicense());
        Assertions.assertEquals("Moto", userParking.getUser().getVehicle().getTypeVehicle().getName());

        Assertions.assertEquals("11111111-1", userParking.getParking().getNit());
        Assertions.assertEquals("UCO", userParking.getParking().getName());
        Assertions.assertEquals("Calle 45", userParking.getParking().getAddress());
    }
}