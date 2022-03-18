package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDAO extends JpaRepository<VehicleEntity, Integer>
{
    VehicleEntity findByLicense(String license);
}
