package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.ReservedTime;
import co.edu.uco.estacionaplus.domain.port.ReservedTimeRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.ReservedTimeDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ReservedTimeAssemblerImplementation.getReservedTimeAssembler;

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
        return this.reservedTimeDAO.findById(code).map(getReservedTimeAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(ReservedTime reservedTime)
    {
        this.reservedTimeDAO.save(getReservedTimeAssembler().assembleEntityFromDomain(reservedTime));
    }

    @Override
    public boolean exists(ReservedTime reservedTime)
    {
        return this.reservedTimeDAO.existsById(reservedTime.getCode());
    }
}