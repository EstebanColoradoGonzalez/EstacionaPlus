package co.edu.uco.estacionaplus.application.service.serviceuserparking;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.domain.service.serviceuserparking.ServiceSaveUserParking;
import org.springframework.stereotype.Component;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserParkingAssemblerImplementation.getUserParkingAssembler;

@Component
public class ServiceApplicationSaveUserParking
{
    private final ServiceSaveUserParking serviceSaveUserParking;

    public ServiceApplicationSaveUserParking(ServiceSaveUserParking serviceSaveUserParking)
    {
        this.serviceSaveUserParking = serviceSaveUserParking;
    }

    public void save(UserParkingDTO userParking)
    {
        this.serviceSaveUserParking.save(getUserParkingAssembler().assembleDomainFromDTO(userParking));
    }
}