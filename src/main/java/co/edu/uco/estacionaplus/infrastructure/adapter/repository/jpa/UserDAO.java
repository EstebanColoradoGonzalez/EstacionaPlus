package co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa;

import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, Integer>
{
    UserEntity findByEmail(String email);
    UserEntity findByIdentificationNumber(String identificationNumber);
}