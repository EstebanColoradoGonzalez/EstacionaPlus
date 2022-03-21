package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Price;

public interface PriceRepository
{
    Price getByCode(int code);
    boolean exists(Price price);
}