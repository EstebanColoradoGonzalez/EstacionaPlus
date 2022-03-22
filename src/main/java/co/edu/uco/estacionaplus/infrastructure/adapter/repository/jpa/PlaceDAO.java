package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.PlaceEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceDAO extends JpaRepository<PlaceEntity, Integer>
{
    PlaceEntity findByPosition(String position);
}