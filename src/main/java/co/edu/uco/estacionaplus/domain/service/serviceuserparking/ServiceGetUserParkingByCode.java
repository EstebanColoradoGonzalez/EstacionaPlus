package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetUserParkingByCode
{
    private final UserParkingRepository userParkingRepository;

    public ServiceGetUserParkingByCode(UserParkingRepository userParkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
    }

    public UserParking getByCode(int code)
    {
        if(!this.userParkingRepository.exists(this.userParkingRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(Message.ADMIN_MESSAGE_IT_DOES_NOT_EXISTS);
        }

        return this.userParkingRepository.getByCode(code);
    }
}