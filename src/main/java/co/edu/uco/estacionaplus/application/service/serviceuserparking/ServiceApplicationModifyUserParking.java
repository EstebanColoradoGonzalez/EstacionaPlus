package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceModifyUserParking;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserParkingAssemblerImplementation.getUserParkingAssembler;

@Component
public class ServiceApplicationModifyUserParking
{
    private final ServiceModifyUserParking serviceModifyUserParking;

    public ServiceApplicationModifyUserParking(ServiceModifyUserParking serviceModifyUserParking)
    {
        this.serviceModifyUserParking = serviceModifyUserParking;
    }

    public void modify(int code, UserParkingDTO userParking)
    {
        this.serviceModifyUserParking.modify(code, getUserParkingAssembler().assembleDomainFromDTO(userParking));
    }
}