package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UserParkingTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var places = new ArrayList<Place>();

        places.add(Place.create(1, "A1", true, TypePlace.create(1, "Motocicleta")));

        var userParking = UserParking.create(1, User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto"))), Parking.create(1, "888888888-3", "Parqueadero", "Calle 35 Numero 33 135", City.create(1, "Marinilla", State.create(1, "Antioquia")), places));

        Assertions.assertEquals("esteban",userParking.getUser().getNames());
        Assertions.assertEquals("colorado",userParking.getUser().getLastNames());
        Assertions.assertEquals("1038418594",userParking.getUser().getIdentificationNumber());
        Assertions.assertEquals("3228486049",userParking.getUser().getPhone());
        Assertions.assertEquals("estebancolorado@gmail.com",userParking.getUser().getEmail());
        Assertions.assertEquals("123456Aa",userParking.getUser().getPassword());
        Assertions.assertEquals("usuario",userParking.getUser().getUserRole().getName());
        Assertions.assertEquals("USV36D",userParking.getUser().getVehicle().getLicense());
        Assertions.assertEquals("moto",userParking.getUser().getVehicle().getTypeVehicle().getName());
        Assertions.assertEquals("888888888-3",userParking.getParking().getNit());
        Assertions.assertEquals("Parqueadero",userParking.getParking().getName());
        Assertions.assertEquals("Calle 35 Numero 33 135",userParking.getParking().getAddress());
        Assertions.assertEquals("Marinilla",userParking.getParking().getCity().getName());
        Assertions.assertEquals("Antioquia",userParking.getParking().getCity().getState().getName());
    }
}
