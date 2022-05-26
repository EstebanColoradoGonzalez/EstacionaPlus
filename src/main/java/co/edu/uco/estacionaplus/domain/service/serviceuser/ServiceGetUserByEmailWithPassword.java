package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserNoSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserByEmailWithPassword
{
    private final UserRepository userRepository;

    public ServiceGetUserByEmailWithPassword(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserNoSummaryDTO getByEmailWithPassword(String email)
    {
        if(!this.userRepository.exists(this.userRepository.getByEmail(email)))
        {
            throw new IllegalArgumentException(Message.USER_MESSAGE_IT_DOES_NOT_EXISTS_WITH_EMAIL);
        }

        return this.userRepository.getByEmailWithPassword(email);
    }
}