package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteUserParking
{
    private final UserParkingRepository userParkingRepository;

    public ServiceDeleteUserParking(UserParkingRepository userParkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
    }

    public void delete(int code)
    {
        if(this.userParkingRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(Message.ADMIN_MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.userParkingRepository.delete(code);
    }
}