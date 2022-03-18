package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ReservationTest
{
    @Test
    void validateSuccessfulCreation()
    {

        var reservation = Reservation.create(1, new Date(), "13:00:00", "14:00:00", ReservedTime.create(1, "1", "Horas"), Price.create(1, 2000), Place.create(1, "A1", TypePlace.create(1, "Moto")), PaymentMethod.create(1, "Tarjeta"), User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto"))));

        Assertions.assertEquals("13:00:00", reservation.getArrivalTime());
        Assertions.assertEquals("14:00:00", reservation.getDepartureTime());
        Assertions.assertEquals("1", reservation.getReservedTime().getValue());
        Assertions.assertEquals("Horas", reservation.getReservedTime().getTypeTime());
        Assertions.assertEquals(2000, reservation.getPrice().getValue());
        Assertions.assertEquals("A1", reservation.getPlace().getPosition());
        Assertions.assertEquals("Moto", reservation.getPlace().getTypePlace().getName());
        Assertions.assertEquals("Tarjeta", reservation.getPaymentMethod().getName());
        Assertions.assertEquals("13:00:00", reservation.getArrivalTime());
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

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The arrivalTime of a Reservation cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(1, new Date(), null, "14:00:00", ReservedTime.create(1, "1", "Horas"), Price.create(1, 2000), Place.create(1, "A1", TypePlace.create(1, "Moto")), PaymentMethod.create(1, "Tarjeta"), User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto"))))).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The arrivalTime of a Reservation cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> Reservation.create(1, new Date(), "", "14:00:00", ReservedTime.create(1, "1", "Horas"), Price.create(1, 2000), Place.create(1, "A1", TypePlace.create(1, "Moto")), PaymentMethod.create(1, "Tarjeta"), User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto"))))).getMessage());
    }
}