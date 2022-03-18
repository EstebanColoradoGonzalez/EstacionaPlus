package co.edu.uco.estacionaplus.infrastructure.adapter.repository;

import co.edu.uco.estacionaplus.domain.model.TypeVehicle;
import co.edu.uco.estacionaplus.domain.port.TypeVehicleRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.TypeVehicleDAO;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

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
        return this.typeVehicleDAO.findAll().stream().map(entity -> TypeVehicle.create(entity.getCode(), entity.getName())).collect(Collectors.toList());
    }

    @Override
    public TypeVehicle getByCode(int code)
    {
        return this.typeVehicleDAO.findById(code).map(entity -> TypeVehicle.create(entity.getCode(), entity.getName())).orElse(null);
    }

    @Override
    public boolean exists(TypeVehicle typeVehicle)
    {
        return this.typeVehicleDAO.existsById(typeVehicle.getCode());
    }
}
