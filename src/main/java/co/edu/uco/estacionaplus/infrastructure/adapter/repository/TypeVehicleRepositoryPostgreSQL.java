package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.port.TypeVehicleRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TypeVehicleRepositoryPostgreSQL implements TypeVehicleRepository
{
    private final TypeVehicleDAO typeVehicleDAO;

    public TypeVehicleRepositoryPostgreSQL(TypeVehicleDAO typeVehicleDAO)
    {
        this.typeVehicleDAO = typeVehicleDAO;
    }

    @Override
    public List<TypeVehicle> getAll()
    {
        return this.typeVehicleDAO.findAll().stream().map(this::assembleTypeVehicle).toList();
    }

    @Override
    public TypeVehicle getByCode(int code)
    {
        return this.typeVehicleDAO.findById(code).map(this::assembleTypeVehicle).orElse(null);
    }

    @Override
    public boolean exists(TypeVehicle typeVehicle)
    {
        return this.typeVehicleDAO.existsById(typeVehicle.getCode());
    }

    private TypeVehicle assembleTypeVehicle(TypeVehicleEntity typeVehicle)
    {
        return TypeVehicle.create(typeVehicle.getCode(), typeVehicle.getName());
    }
}
