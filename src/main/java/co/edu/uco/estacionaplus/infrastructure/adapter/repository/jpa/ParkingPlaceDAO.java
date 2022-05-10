package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.ParkingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingPlaceDAO extends JpaRepository<ParkingPlaceEntity, Integer>
{
}
