package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.TypePlace;
import co.edu.uco.estacionaplus.domain.port.TypePlaceRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypePlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypePlaceDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

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
        return this.typePlaceDAO.findAll().stream().map(this::assembleTypePlace).toList();
    }

    @Override
    public TypePlace getByCode(int code)
    {
        return this.typePlaceDAO.findById(code).map(this::assembleTypePlace).orElse(null);
    }

    @Override
    public boolean exists(TypePlace typePlace)
    {
        return this.typePlaceDAO.existsById(typePlace.getCode());
    }

    private TypePlace assembleTypePlace(TypePlaceEntity typePlace)
    {
        return TypePlace.create(typePlace.getCode(), typePlace.getName());
    }
}
