package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class ReservationTest
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
        var reservedTime = ReservedTime.create(1, 2, "Horas");
        var price = Price.create(1, 5000);
        var typePlace = TypePlace.create(1, "Moto");
        var place = Place.create(1, "A1", typePlace);
        var parkingPlace = ParkingPlace.create(1, false, place);
        var paymentMethod = PaymentMethod.create(1, "Tarjeta");
        var reservation = Reservation.create(1, LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(2), reservedTime, price, parkingPlace, paymentMethod, user);

        Assertions.assertEquals("Esteban", reservation.getUser().getNames());
        Assertions.assertEquals("Colorado González", reservation.getUser().getLastNames());
        Assertions.assertEquals("1038418594", reservation.getUser().getIdentificationNumber());
        Assertions.assertEquals("3228486049", reservation.getUser().getPhone());
        Assertions.assertEquals("estebancoloradogonzalez@gmail.com", reservation.getUser().getEmail());
        Assertions.assertEquals("123456789Aa", reservation.getUser().getPassword());
        Assertions.assertEquals("ROLE_USER", reservation.getUser().getRoles().get(0).getName());
        Assertions.assertEquals("USV36D", reservation.getUser().getVehicle().getLicense());
        Assertions.assertEquals("Moto", reservation.getUser().getVehicle().getTypeVehicle().getName());
    }
}
