package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import co.edu.uco.estacionaplus.domain.assembler.UserRoleAssembler;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.RoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import java.util.List;

public class UserRoleAssemblerImplementation implements UserRoleAssembler
{
    private static final UserRoleAssembler INSTANCE = new UserRoleAssemblerImplementation();

    private UserRoleAssemblerImplementation()
    {

    }

    public static UserRoleAssembler getUserRoleAssembler()
    {
        return INSTANCE;
    }

    @Override
    public UserRole assembleDomainFromEntity(UserRoleEntity entity)
    {
        return UserRole.create(entity.getCode(), entity.getRole().getName());
    }

    @Override
    public UserRoleEntity assembleEntityFromDomain(UserRole domain)
    {
        int code = 1;

        if(domain.getName().equals("ROLE_ADMIN"))
        {
            code = 2;
        }

        return new UserRoleEntity(domain.getCode(), new RoleEntity(code, domain.getName()));
    }

    @Override
    public UserRole assembleDomainFromDTO(UserRoleDTO dto)
    {
        return UserRole.create(dto.getCode(), dto.getName());
    }

    @Override
    public UserRoleDTO assembleDTOFromDomain(UserRole domain)
    {
        return new UserRoleDTO(domain.getCode(), domain.getName());
    }

    @Override
    public List<UserRole> assembleDomainsFromEntities(List<UserRoleEntity> entities)
    {
        return entities.stream().map(getUserRoleAssembler()::assembleDomainFromEntity).toList();
    }

    @Override
    public List<UserRoleEntity> assembleEntitiesFromDomains(List<UserRole> domains)
    {
        return domains.stream().map(getUserRoleAssembler()::assembleEntityFromDomain).toList();
    }

    @Override
    public List<UserRoleDTO> assembleDTOsFromDomains(List<UserRole> domains)
    {
        return domains.stream().map(getUserRoleAssembler()::assembleDTOFromDomain).toList();
    }

    @Override
    public List<UserRole> assembleDomainsFromDTOs(List<UserRoleDTO> dtos)
    {
        return dtos.stream().map(getUserRoleAssembler()::assembleDomainFromDTO).toList();
    }

    @Override
    public List<UserRoleSummaryDTO> assembleSummaryDTOsFromEntities(List<UserRoleEntity> entities)
    {
        return entities.stream().map(getUserRoleAssembler()::assembleSummaryDTOFromEntity).toList();
    }

    @Override
    public List<UserRoleSummaryDTO> assembleSummaryDTOsFromDomains(List<UserRole> domains)
    {
        return domains.stream().map(getUserRoleAssembler()::assembleSummaryDTOFromDomain).toList();
    }

    @Override
    public UserRoleSummaryDTO assembleSummaryDTOFromEntity(UserRoleEntity entity)
    {
        return new UserRoleSummaryDTO(entity.getCode(), entity.getRole().getName());
    }

    @Override
    public UserRoleSummaryDTO assembleSummaryDTOFromDomain(UserRole domain)
    {
        return new UserRoleSummaryDTO(domain.getCode(), domain.getName());
    }

    @Override
    public UserRoleEntity assembleEntityFromDomainToSave(int code, RoleEntity role)
    {
        return new UserRoleEntity(code, role);
    }
}