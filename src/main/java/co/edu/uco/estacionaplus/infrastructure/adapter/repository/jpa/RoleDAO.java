package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<RoleEntity, Integer>
{

}