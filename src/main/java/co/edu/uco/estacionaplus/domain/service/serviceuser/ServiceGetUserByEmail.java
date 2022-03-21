package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserByEmail 
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This user doesn't exists with this email";

    private final UserRepository userRepository;

    public ServiceGetUserByEmail(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserSummaryDTO getByEmail(String email)
    {
        if(!this.userRepository.exists(this.userRepository.getByEmail(email)))
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }
        
        return this.userRepository.getByEmail(email);
    }
}