package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceDeleteUserParking
{
    private static final String MESSAGE_IT_DOES_NOT_EXISTS = "This admin doesn't exists with this code";

    private final UserParkingRepository userParkingRepository;

    public ServiceDeleteUserParking(UserParkingRepository userParkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
    }

    public void delete(int code)
    {
        if(this.userParkingRepository.getByCode(code) == null)
        {
            throw new IllegalArgumentException(MESSAGE_IT_DOES_NOT_EXISTS);
        }

        this.userParkingRepository.delete(code);
    }
}