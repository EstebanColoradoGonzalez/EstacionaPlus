package co.edu.uco.estacionaplus.domain.service.serviceparking;

import co.edu.uco.estacionaplus.domain.model.Parking;
import co.edu.uco.estacionaplus.domain.port.ParkingRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetParkingByCode
{
    private final ParkingRepository parkingRepository;

    public ServiceGetParkingByCode(ParkingRepository parkingRepository)
    {
        this.parkingRepository = parkingRepository;
    }

    public Parking getByCode(int code)
    {
        if(!this.parkingRepository.exists(this.parkingRepository.getByCode(code)))
        {
            throw new IllegalArgumentException(Message.PARKING_MESSAGE_IT_DOES_NOT_EXISTS);
        }

        return this.parkingRepository.getByCode(code);
    }
}