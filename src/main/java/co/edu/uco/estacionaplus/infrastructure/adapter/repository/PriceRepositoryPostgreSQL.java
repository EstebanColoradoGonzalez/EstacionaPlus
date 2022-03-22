package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.Price;
import co.edu.uco.estacionaplus.domain.port.PriceRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PriceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.PriceDAO;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRepositoryPostgreSQL implements PriceRepository
{
    private final PriceDAO priceDAO;

    public PriceRepositoryPostgreSQL(PriceDAO priceDAO)
    {
        this.priceDAO = priceDAO;
    }

    @Override
    public Price getByCode(int code)
    {
        return this.priceDAO.findById(code).map(this::assemblePrice).orElse(null);
    }

    @Override
    public boolean exists(Price price)
    {
        return this.priceDAO.existsById(price.getCode());
    }

    private Price assemblePrice(PriceEntity price)
    {
        return Price.create(price.getCode(), price.getValue());
    }
}