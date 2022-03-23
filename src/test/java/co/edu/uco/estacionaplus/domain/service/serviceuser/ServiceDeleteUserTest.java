package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServiceDeleteUserTest
{
    @Test
    void returnErrorIfEmailDoesNotExists()
    {
        var user = new UserTestDataBuilder().build();

        var repository = Mockito.mock(UserRepository.class);
        var service = new ServiceDeleteUser(repository);

        Mockito.when(!repository.exists(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("This user doesn't exists with this code", Assertions.assertThrows(IllegalArgumentException.class, () -> service.delete(1)).getMessage());
    }
}