package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest
{
    @Test
    void validateSuccessfulCreation()
    {

        var user = User.create(1, "esteban", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto")));

        Assertions.assertEquals("esteban",user.getNames());
        Assertions.assertEquals("colorado",user.getLastNames());
        Assertions.assertEquals("1038418594",user.getIdentificationNumber());
        Assertions.assertEquals("3228486049",user.getPhone());
        Assertions.assertEquals("estebancolorado@gmail.com",user.getEmail());
        Assertions.assertEquals("123456Aa",user.getPassword());
        Assertions.assertEquals("usuario",user.getUserRole().getName());
        Assertions.assertEquals("USV36D",user.getVehicle().getLicense());
        Assertions.assertEquals("moto",user.getVehicle().getTypeVehicle().getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The names of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, null, "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto")))).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The names of a User cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "", "colorado", "1038418594", "3228486049", "estebancolorado@gmail.com", "123456Aa", UserRole.create(1, "usuario"), Vehicle.create(1, "USV36D", TypeVehicle.create(1, "moto")))).getMessage());
    }
}