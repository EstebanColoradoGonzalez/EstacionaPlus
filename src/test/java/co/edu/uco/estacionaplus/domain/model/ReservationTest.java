package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ReservationTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var reservation = Reservation.create(1, LocalDate.now(), UtilTime.getTime("13:00:00"), UtilTime.getTime("14:00:00"), ReservedTime.create(1, 1, "Horas"), Price.create(1, 2000), Place.create(1, "A1", true, TypePlace.create(1, "Moto")), PaymentMethod.create(1, "Tarjeta"), User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto"))));

        Assertions.assertEquals(UtilTime.getTime("13:00:00"), reservation.getArrivalTime());
        Assertions.assertEquals(UtilTime.getTime("14:00:00"), reservation.getDepartureTime());
        Assertions.assertEquals(1, reservation.getReservedTime().getValue());
        Assertions.assertEquals("Horas", reservation.getReservedTime().getTypeTime());
        Assertions.assertEquals(2000, reservation.getPrice().getValue());
        Assertions.assertEquals("A1", reservation.getPlace().getPosition());
        Assertions.assertEquals("Moto", reservation.getPlace().getTypePlace().getName());
        Assertions.assertEquals("Tarjeta", reservation.getPaymentMethod().getName());
        Assertions.assertEquals("esteban",reservation.getUser().getNames());
        Assertions.assertEquals("colorado",reservation.getUser().getLastNames());
        Assertions.assertEquals("1038418594",reservation.getUser().getIdentificationNumber());
        Assertions.assertEquals("3228486049",reservation.getUser().getPhone());
        Assertions.assertEquals("estebancolorado@gmail.com",reservation.getUser().getEmail());
        Assertions.assertEquals("123456Aa",reservation.getUser().getPassword());
        Assertions.assertEquals("usuario",reservation.getUser().getUserRole().getName());
        Assertions.assertEquals("USV36D",reservation.getUser().getVehicle().getLicense());
        Assertions.assertEquals("moto",reservation.getUser().getVehicle().getTypeVehicle().getName());
    }
}