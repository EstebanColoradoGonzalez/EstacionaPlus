package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.domain.assembler.UserParkingAssembler;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserParkingEntity;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.ParkingAssemblerImplementation.getParkingAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserAssemblerImplementation.getUserAssembler;

public class UserParkingAssemblerImplementation implements UserParkingAssembler
{
    private static final UserParkingAssembler INSTANCE = new UserParkingAssemblerImplementation();

    private UserParkingAssemblerImplementation()
    {

    }

    public static UserParkingAssembler getUserParkingAssembler()
    {
        return INSTANCE;
    }

    @Override
    public UserParking assembleDomainFromEntity(UserParkingEntity entity)
    {
        return UserParking.create(entity.getCode(), getUserAssembler().assembleDomainFromEntity(entity.getUser()), getParkingAssembler().assembleDomainFromEntity(entity.getParking()));
    }

    @Override
    public UserParkingEntity assembleEntityFromDomain(UserParking domain)
    {
        return new UserParkingEntity(domain.getCode(), getUserAssembler().assembleEntityFromDomain(domain.getUser()), getParkingAssembler().assembleEntityFromDomain(domain.getParking()));
    }

    @Override
    public UserParking assembleDomainFromDTO(UserParkingDTO dto)
    {
        return UserParking.create(dto.getCode(), getUserAssembler().assembleDomainFromDTO(dto.getUser()), getParkingAssembler().assembleDomainFromDTO(dto.getParking()));
    }

    @Override
    public UserParkingDTO assembleDTOFromDomain(UserParking domain)
    {
        return new UserParkingDTO(domain.getCode(), getUserAssembler().assembleDTOFromDomain(domain.getUser()), getParkingAssembler().assembleDTOFromDomain(domain.getParking()));
    }

    @Override
    public UserParkingEntity assembleEntityFromDomainToSave(UserParking domain, User user)
    {
        return new UserParkingEntity(domain.getCode(), getUserAssembler().assembleEntityFromDomain(user), getParkingAssembler().assembleEntityFromDomain(domain.getParking()));
    }

    @Override
    public UserParkingEntity assembleEntityFromDomainToModify(int code, UserParking domain)
    {
        return new UserParkingEntity(code, getUserAssembler().assembleEntityFromDomain(domain.getUser()), getParkingAssembler().assembleEntityFromDomain(domain.getParking()));
    }
}
