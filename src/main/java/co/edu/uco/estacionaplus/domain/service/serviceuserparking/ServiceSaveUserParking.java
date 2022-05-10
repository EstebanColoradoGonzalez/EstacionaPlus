package co.edu.uco.estacionaplus.domain.service.serviceuserparking;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.port.UserRoleRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateObject;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

@Service
public class ServiceSaveUserParking
{
    private final UserParkingRepository userParkingRepository;
    private final UserRepository userRepository;
    private final ParkingRepository parkingRepository;
    private final UserRoleRepository userRoleRepository;

    public ServiceSaveUserParking(UserParkingRepository userParkingRepository, UserRepository userRepository, ParkingRepository parkingRepository, UserRoleRepository userRoleRepository)
    {
        this.userParkingRepository = userParkingRepository;
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public void save(UserParking userParking)
    {
        checkUserDoesNotExists(userParking.getUser());
        checkParkingDoesNotExistsWithNIT(userParking.getParking().getNit());
        checkParkingDoesNotExistsWithAddress(userParking.getParking().getAddress());

        List<UserRole> roles = new ArrayList<>();

        roles.add(UserRole.create(1, "ROLE_USER"));
        roles.add(UserRole.create(2, "ROLE_ADMIN"));


        this.userRoleRepository.save(roles.get(1));
        this.userRepository.modify(userParking.getUser().getCode(), getUserAssembler().assembleDomainFromDomainToModify(userParking.getUser(), roles));
        this.userParkingRepository.save(userParking);
    }

    private void checkUserDoesNotExists(User user)
    {
        if(!this.userRepository.exists(getUserAssembler().assembleSummaryDTOFromEntity(getUserAssembler().assembleEntityFromDomain(user))))
        {
            throw new IllegalArgumentException(Message.MESSAGE_USER_DOES_NOT_EXISTS);
        }
    }

    private void checkParkingDoesNotExistsWithNIT(String nit)
    {
        var parking = this.parkingRepository.getByNIT(nit);

        if(!ValidateObject.isNull(parking))
        {
            throw new IllegalArgumentException(Message.MESSAGE_EXISTS_WITH_NIT);
        }
    }

    private void checkParkingDoesNotExistsWithAddress(String address)
    {
        var parking = this.parkingRepository.getByAddress(address);

        if(!ValidateObject.isNull(parking))
        {
            throw new IllegalArgumentException(Message.MESSAGE_EXISTS_WITH_ADDRESS);
        }
    }
}