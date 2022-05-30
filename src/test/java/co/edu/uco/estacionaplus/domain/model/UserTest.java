package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest
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

        Assertions.assertEquals("Esteban", user.getNames());
        Assertions.assertEquals("Colorado González", user.getLastNames());
        Assertions.assertEquals("1038418594", user.getIdentificationNumber());
        Assertions.assertEquals("3228486049", user.getPhone());
        Assertions.assertEquals("estebancoloradogonzalez@gmail.com", user.getEmail());
        Assertions.assertEquals("123456789Aa", user.getPassword());
        Assertions.assertEquals("ROLE_USER", user.getRoles().get(0).getName());
        Assertions.assertEquals("USV36D", user.getVehicle().getLicense());
        Assertions.assertEquals("Moto", user.getVehicle().getTypeVehicle().getName());
    }

    @Test
    void validateMissingFields()
    {
        var userRole = UserRole.create(1, "ROLE_USER");
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRole);
        var typeVehicle = TypeVehicle.create(1, "Moto");
        var vehicle = Vehicle.create(1, "USV36D", typeVehicle);

        Assertions.assertEquals("The names of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, null, "Colorado González", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The lastNames of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", null, "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The identificationNumber of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", null, "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The phone of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", null, "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The email of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", "3228486049", null, "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The password of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", null, roles, vehicle)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        var userRole = UserRole.create(1, "ROLE_USER");
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRole);
        var typeVehicle = TypeVehicle.create(1, "Moto");
        var vehicle = Vehicle.create(1, "USV36D", typeVehicle);

        Assertions.assertEquals("The names of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "", "Colorado González", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The lastNames of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The identificationNumber of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "", "3228486049", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The phone of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", "", "estebancoloradogonzalez@gmail.com", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The email of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", "3228486049", "", "123456789Aa", roles, vehicle)).getMessage());
        Assertions.assertEquals("The password of a User cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> User.create(1, "Esteban", "Colorado González", "1038418594", "3228486049", "estebancoloradogonzalez@gmail.com", "", roles, vehicle)).getMessage());
    }
}