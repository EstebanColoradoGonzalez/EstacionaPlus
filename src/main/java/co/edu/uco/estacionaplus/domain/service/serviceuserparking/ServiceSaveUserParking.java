package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilObject;
import org.springframework.stereotype.Service;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Service
public class ServiceSaveUserParking
{
    private final UserParkingRepository userParkingRepository;
    private final UserRepository userRepository;
    private final ParkingRepository parkingRepository;

    public ServiceSaveUserParking(UserParkingRepository userParkingRepository, UserRepository userRepository, ParkingRepository parkingRepository)
    {
        this.userParkingRepository = userParkingRepository;
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
    }

    public void save(UserParking userParking)
    {
        checkUserDoesNotExists(userParking.getUser());
        checkParkingDoesNotExistsWithNIT(userParking.getParking().getNit());
        checkParkingDoesNotExistsWithAddress(userParking.getParking().getAddress());
        this.userRepository.modify(userParking.getUser().getCode(), userParking.getUser());
        this.userParkingRepository.save(userParking);
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(getUserAssembler().assembleSummaryDTOFromEntity(getUserAssembler().assembleEntityFromDomain(user))))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_USER_DOES_NOT_EXISTS);
        }
    }

    private void checkParkingDoesNotExistsWithNIT(String nit)
    {
        var parking = this.parkingRepository.getByNIT(nit);

        if(!UtilObject.isNull(parking))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_NIT);
        }
    }

    private void checkParkingDoesNotExistsWithAddress(String address)
    {
        var parking = this.parkingRepository.getByAddress(address);

        if(!UtilObject.isNull(parking))
        {
            throw new IllegalArgumentException(UtilMessage.MESSAGE_EXISTS_WITH_ADDRESS);
        }
    }
}