package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteUser
{
    private final UserRepository userRepository;

    public ServiceDeleteUser(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void delete(int code)
    {
        if(this.userRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(Message.USER_MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.userRepository.delete(code);
    }
}