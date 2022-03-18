package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.model.Price;

public interface PriceRepository
{
    Price getByCode(int code);
    void save(Price price);
    void modify(int code, Price price);
    void delete(int code);
    boolean exists(Price price);
}
