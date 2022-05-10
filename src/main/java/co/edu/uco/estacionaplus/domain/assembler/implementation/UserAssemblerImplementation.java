package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.assembler.UserAssembler;
import co.edu.uco.estacionaplus.domain.dto.UserNoSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import java.util.List;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.UserRoleAssemblerImplementation.getUserRoleAssembler;
import static co.edu.uco.estacionaplus.domain.assembler.implementation.VehicleAssemblerImplementation.getVehicleAssembler;

public class UserAssemblerImplementation implements UserAssembler
{
    private static final UserAssembler INSTANCE = new UserAssemblerImplementation();

    private UserAssemblerImplementation()
    {

    }

    public static UserAssembler getUserAssembler()
    {
        return INSTANCE;
    }

    @Override
    public User assembleDomainFromEntity(UserEntity entity)
    {
        return User.create(entity.getCode(), entity.getNames(), entity.getLastNames(), entity.getIdentificationNumber(), entity.getPhone(), entity.getEmail(), entity.getPassword(), getUserRoleAssembler().assembleDomainsFromEntities(entity.getRoles()), getVehicleAssembler().assembleDomainFromEntity(entity.getVehicle()));
    }

    @Override
    public UserEntity assembleEntityFromDomain(User domain)
    {
        return new UserEntity(domain.getCode(), domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), domain.getPassword(), getUserRoleAssembler().assembleEntitiesFromDomains(domain.getRoles()), getVehicleAssembler().assembleEntityFromDomain(domain.getVehicle()));
    }

    @Override
    public User assembleDomainFromDTO(UserDTO dto)
    {
        return User.create(dto.getCode(), dto.getNames(), dto.getLastNames(), dto.getIdentificationNumber(), dto.getPhone(), dto.getEmail(), dto.getPassword(), getUserRoleAssembler().assembleDomainsFromDTOs(dto.getRoles()), getVehicleAssembler().assembleDomainFromDTO(dto.getVehicle()));
    }

    @Override
    public UserDTO assembleDTOFromDomain(User domain)
    {
        return new UserDTO(domain.getCode(), domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), domain.getPassword(), getUserRoleAssembler().assembleDTOsFromDomains(domain.getRoles()), getVehicleAssembler().assembleDTOFromDomain(domain.getVehicle()));
    }

    @Override
    public UserSummaryDTO assembleSummaryDTOFromEntity(UserEntity entity)
    {
        return new UserSummaryDTO(entity.getCode(), entity.getNames(), entity.getLastNames(), entity.getIdentificationNumber(), entity.getPhone(), entity.getEmail(), getUserRoleAssembler().assembleSummaryDTOsFromEntities(entity.getRoles()), getVehicleAssembler().assembleSummaryDTOFromEntity(entity.getVehicle()));
    }

    @Override
    public UserNoSummaryDTO assembleNoSummaryDTOFromEntity(UserEntity entity)
    {
        return new UserNoSummaryDTO(entity.getCode(), entity.getNames(), entity.getLastNames(), entity.getIdentificationNumber(), entity.getPhone(), entity.getEmail(), entity.getPassword(), getUserRoleAssembler().assembleSummaryDTOsFromEntities(entity.getRoles()), getVehicleAssembler().assembleSummaryDTOFromEntity(entity.getVehicle()));
    }

    @Override
    public UserSummaryDTO assembleSummaryDTOFromDomain(User domain)
    {
        return new UserSummaryDTO(domain.getCode(), domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), getUserRoleAssembler().assembleSummaryDTOsFromDomains(domain.getRoles()), getVehicleAssembler().assembleSummaryDTOFromDomain(domain.getVehicle()));
    }

    @Override
    public UserEntity assembleEntityFromDomainToSave(User domain, List<UserRoleEntity> roles, TypeVehicleEntity typeVehicle)
    {
        return new UserEntity(domain.getCode(), domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), domain.getPassword(), roles, getVehicleAssembler().assembleEntityFromDomainToSave(domain.getVehicle(), typeVehicle));
    }

    @Override
    public User assembleDomainFromDomainToModify(User domain, List<UserRole> roles)
    {
        return User.create(domain.getCode(), domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), domain.getPassword(), roles, domain.getVehicle());
    }

    @Override
    public UserEntity assembleEntityFromDomainToModify(int code, User domain)
    {
        return new UserEntity(code, domain.getNames(), domain.getLastNames(), domain.getIdentificationNumber(), domain.getPhone(), domain.getEmail(), domain.getPassword(), getUserRoleAssembler().assembleEntitiesFromDomains(domain.getRoles()), getVehicleAssembler().assembleEntityFromDomain(domain.getVehicle()));
    }
}