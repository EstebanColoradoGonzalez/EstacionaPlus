package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserByCode
{
    private final UserRepository userRepository;

    public ServiceGetUserByCode(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserSummaryDTO getByCode(int code)
    {
        if(!this.userRepository.exists(this.userRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(Message.USER_MESSAGE_IT_DOES_NOT_EXISTS);
        }
        return this.userRepository.getByCode(code);
    }
}