package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.Vehicle;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.domain.port.VehicleRepository;
import co.edu.uco.estacionaplus.domain.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServiceSaveUserTest
{
    @Test
    void returnErrorIfUserRoleDoesNotExists()
    {
        var user = new UserTestDataBuilder().build();

        var userRepository = Mockito.mock(UserRepository.class);
        var userRoleRepository = Mockito.mock(UserRoleRepository.class);

        var service = new ServiceSaveUser(userRepository, userRoleRepository);

        Mockito.when(userRepository.exists(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("This user role doesn't exists with this name.", Assertions.assertThrows(IllegalArgumentException.class, () -> service.save(user)).getMessage());
    }
}