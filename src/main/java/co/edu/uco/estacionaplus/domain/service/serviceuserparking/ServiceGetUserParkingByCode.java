package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserParkingByCode
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This admin doesn't exists with this code";

    private final UserParkingRepository userParkingRepository;

    public ServiceGetUserParkingByCode(UserParkingRepository userParkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
    }

    public UserParking getByCode(int code)
    {
        if(!this.userParkingRepository.exists(this.userParkingRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }

        return this.userParkingRepository.getByCode(code);
    }
}