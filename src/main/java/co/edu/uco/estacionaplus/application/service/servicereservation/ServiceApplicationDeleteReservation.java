package co.edu.uco.estacionaplus.application.service.servicereservation;

import co.edu.uco.estacionaplus.domain.service.servicereservation.ServiceDeleteReservation;
import org.springframework.stereotype.Component;

@Component
public class ServiceApplicationDeleteReservation
{
    private final ServiceDeleteReservation serviceDeleteReservation;

    public ServiceApplicationDeleteReservation(ServiceDeleteReservation serviceDeleteReservation)
    {
        this.serviceDeleteReservation = serviceDeleteReservation;
    }

    public void delete(int code)
    {
        this.serviceDeleteReservation.delete(code);
    }
}