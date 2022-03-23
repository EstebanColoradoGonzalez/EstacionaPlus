package co.edu.uco.estacionaplus.domain.assembler.implementation;

import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import co.edu.uco.estacionaplus.domain.assembler.UserRoleAssembler;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;

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
        return UserRole.create(entity.getCode(), entity.getName());
    }

    @Override
    public UserRoleEntity assembleEntityFromDomain(UserRole domain)
    {
        return new UserRoleEntity(domain.getCode(), domain.getName());
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
    public UserRoleSummaryDTO assembleSummaryDTOFromEntity(UserRoleEntity entity)
    {
        return new UserRoleSummaryDTO(entity.getCode(), entity.getName());
    }

    @Override
    public UserRoleSummaryDTO assembleSummaryDTOFromDomain(UserRole domain)
    {
        return new UserRoleSummaryDTO(domain.getCode(), domain.getName());
    }
}
