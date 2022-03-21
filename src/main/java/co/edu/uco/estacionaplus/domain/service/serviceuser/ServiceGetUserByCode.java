package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserByCode
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This user doesn't exists with this code";

    private final UserRepository userRepository;

    public ServiceGetUserByCode(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public UserSummaryDTO getByCode(int code)
    {
        if(!this.userRepository.exists(this.userRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }
        return this.userRepository.getByCode(code);
    }
}