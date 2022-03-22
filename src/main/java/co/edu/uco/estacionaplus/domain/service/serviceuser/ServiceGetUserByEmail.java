package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserByEmail 
{
    private final UserRepository userRepository;

    public ServiceGetUserByEmail(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserSummaryDTO getByEmail(String email)
    {
        if(!this.userRepository.exists(this.userRepository.getByEmail(email)))
        {
            throw new IllegalArgumentException(UtilMessage.USER_MESSAGE_IT_DOES_NOT_EXISTS_WITH_EMAIL);
        }
        
        return this.userRepository.getByEmail(email);
    }
}