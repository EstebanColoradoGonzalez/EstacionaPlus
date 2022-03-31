package co.edu.uco.estacionaplus.domain.service.serviceparking;

import co.edu.uco.estacionaplus.domain.model.Parking;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceGetParkings
{
    private final ParkingRepository parkingRepository;

    public ServiceGetParkings(ParkingRepository parkingRepository)
    {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAll()
    {
        return this.parkingRepository.getAll();
    }
}