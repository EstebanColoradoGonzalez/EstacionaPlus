package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.ReservedTime;
import co.edu.uco.estacionaplus.domain.port.ReservedTimeRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ReservedTimeEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ReservedTimeDAO;
import org.springframework.stereotype.Repository;

@Repository
public class ReservedTimeRepositoryPostgreSQL implements ReservedTimeRepository
{
    private final ReservedTimeDAO reservedTimeDAO;

    public ReservedTimeRepositoryPostgreSQL(ReservedTimeDAO reservedTimeDAO)
    {
        this.reservedTimeDAO = reservedTimeDAO;
    }

    @Override
    public ReservedTime getByCode(int code)
    {
        return this.reservedTimeDAO.findById(code).map(this::assembleReservedTime).orElse(null);
    }

    @Override
    public void save(ReservedTime reservedTime)
    {
        this.reservedTimeDAO.save(assembleReservedTimeEntity(reservedTime));
    }

    @Override
    public boolean exists(ReservedTime reservedTime)
    {
        return this.reservedTimeDAO.existsById(reservedTime.getCode());
    }

    private ReservedTime assembleReservedTime(ReservedTimeEntity reservedTime)
    {
        return ReservedTime.create(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }

    private ReservedTimeEntity assembleReservedTimeEntity(ReservedTime reservedTime)
    {
        return new ReservedTimeEntity(reservedTime.getCode(), reservedTime.getValue(), reservedTime.getTypeTime());
    }
}