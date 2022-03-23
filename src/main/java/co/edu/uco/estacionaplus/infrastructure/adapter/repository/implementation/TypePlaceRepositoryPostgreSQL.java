package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.domain.port.TypePlaceRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypePlaceDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.TypePlaceAssemblerImplementation.getTypePlaceAssembler;

@Repository
public class TypePlaceRepositoryPostgreSQL implements TypePlaceRepository
{
    private final TypePlaceDAO typePlaceDAO;

    public TypePlaceRepositoryPostgreSQL(TypePlaceDAO typePlaceDAO)
    {
        this.typePlaceDAO = typePlaceDAO;
    }

    @Override
    public List<TypePlace> getAll()
    {
        return this.typePlaceDAO.findAll().stream().map(getTypePlaceAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public TypePlace getByCode(int code)
    {
        return this.typePlaceDAO.findById(code).map(getTypePlaceAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public boolean exists(TypePlace typePlace)
    {
        return this.typePlaceDAO.existsById(typePlace.getCode());
    }
}