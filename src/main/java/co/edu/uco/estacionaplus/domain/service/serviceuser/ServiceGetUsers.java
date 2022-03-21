package co.edu.uco.estacionaplus.domain.service.serviceuser;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceGetUsers
{
    private final UserRepository userRepository;

    public ServiceGetUsers(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public List<UserSummaryDTO> getAll()
    {
        return this.userRepository.getAll();
    }
}