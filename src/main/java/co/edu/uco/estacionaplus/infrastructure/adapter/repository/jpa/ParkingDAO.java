package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingDAO extends JpaRepository<ParkingEntity, Integer>
{
    ParkingEntity findByNit(String nit);
    ParkingEntity findByAddress(String address);
}