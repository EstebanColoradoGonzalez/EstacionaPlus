package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceModifyUser
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This user doesn't exists with this code";
    private final UserRepository userRepository;

    public ServiceModifyUser(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void modify(int code, User user)
    {
        if(this.userRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.userRepository.modify(code, user);
    }
}