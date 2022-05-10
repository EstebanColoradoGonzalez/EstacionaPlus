package co.edu.uco.estacionaplus.infrastructure.adapter.repository.implementation;

import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.domain.port.UserParkingRepository;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserDAO;
import co.edu.uco.estacionaplus.infrastructure.adapter.repository.jpa.UserParkingDAO;
import org.springframework.stereotype.Repository;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserParkingAssemblerImplementation.getUserParkingAssembler;

@Repository
public class UserParkingRepositoryPostgreSQL implements UserParkingRepository
{
    private final UserParkingDAO userParkingDAO;
    private final UserDAO userDAO;

    public UserParkingRepositoryPostgreSQL(UserParkingDAO userParkingDAO, UserDAO userDAO)
    {
        this.userParkingDAO = userParkingDAO;
        this.userDAO = userDAO;
    }

    @Override
    public UserParking getByCode(int code)
    {
        return this.userParkingDAO.findById(code).map(getUserParkingAssembler()::assembleDomainFromEntity).orElse(null);
    }

    @Override
    public void save(UserParking userParking)
    {
        var user = this.userDAO.findById(userParking.getUser().getCode()).orElse(null);

        this.userParkingDAO.save(getUserParkingAssembler().assembleEntityFromDomainToSave(userParking, user));
    }

    @Override
    public void modify(int code, UserParking userParking)
    {
        this.userParkingDAO.save(getUserParkingAssembler().assembleEntityFromDomainToModify(code, userParking));
    }

    @Override
    public void delete(int code)
    {
        this.userParkingDAO.deleteById(code);
    }

    @Override
    public boolean exists(UserParking userParking)
    {
        return this.userParkingDAO.existsById(userParking.getCode());
    }
}