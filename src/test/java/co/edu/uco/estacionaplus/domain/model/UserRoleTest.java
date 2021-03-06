package co.edu.uco.estacionaplus.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserRoleTest
{
    @Test
    void validateSuccessfulCreation()
    {
        var userRole = UserRole.create(1, "ROLE_USER");

        Assertions.assertEquals("ROLE_USER", userRole.getName());
    }

    @Test
    void validateMissingFields()
    {
        Assertions.assertEquals("The name of a User Role cannot be empty.",Assertions.assertThrows(IllegalArgumentException.class, () -> UserRole.create(1, null)).getMessage());
    }

    @Test
    void ValidateEmptyFields()
    {
        Assertions.assertEquals("The name of a User Role cannot be empty.", Assertions.assertThrows(IllegalArgumentException.class, () -> UserRole.create(1, "")).getMessage());
    }
}