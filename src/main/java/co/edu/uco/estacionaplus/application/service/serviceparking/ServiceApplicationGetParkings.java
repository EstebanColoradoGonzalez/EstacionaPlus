package co.edu.uco.estacionaplus.application.service.serviceparking;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.domain.service.serviceparking.ServiceGetParkings;
import org.springframework.stereotype.Component;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingAssemblerImplementation.getParkingAssembler;

@Component
public class ServiceApplicationGetParkings
{
    private final ServiceGetParkings serviceGetParkings;

    public ServiceApplicationGetParkings(ServiceGetParkings serviceGetParkings)
    {
        this.serviceGetParkings = serviceGetParkings;
    }

    public List<ParkingDTO> getAll()
    {
        return getParkingAssembler().assembleDTOsFromDomain(serviceGetParkings.getAll());
    }
}