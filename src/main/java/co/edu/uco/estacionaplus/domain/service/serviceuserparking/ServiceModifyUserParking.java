package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;

@Service
public class ServiceModifyUserParking
{
    private final UserParkingRepository userParkingRepository;
    private final ParkingRepository parkingRepository;

    public ServiceModifyUserParking(UserParkingRepository userParkingRepository, ParkingRepository parkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
        this.parkingRepository = parkingRepository;
    }

    public void modify(int code, UserParking userParking)
    {
        checkParkingDoesNotExistsWithNIT(code, userParking);
        checkParkingDoesNotExistsWithAddress(code, userParking);

        this.userParkingRepository.modify(code, userParking);
    }

    private void checkParkingDoesNotExistsWithNIT(int code, UserParking userParking)
    {
        var parking = this.parkingRepository.getByNIT(userParking.getParking().getNit());

        if(!UtilObject.isNull(parking) && userParking.getCode() != code)
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_NIT);
        }
    }

    private void checkParkingDoesNotExistsWithAddress(int code, UserParking userParking)
    {
        var parking = this.parkingRepository.getByAddress(userParking.getParking().getAddress());

        if(!UtilObject.isNull(parking) && userParking.getCode() != code)
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_ADDRESS);
        }
    }
}