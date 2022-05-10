package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.RoleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;
import java.util.List;

public interface UserRoleAssembler extends Assembler<UserRole, UserRoleEntity, UserRoleDTO>
{
    List<UserRole> assembleDomainsFromEntities(List<UserRoleEntity> entities);
    List<UserRoleEntity> assembleEntitiesFromDomains(List<UserRole> domains);
    List<UserRoleDTO> assembleDTOsFromDomains(List<UserRole> domains);
    List<UserRole> assembleDomainsFromDTOs(List<UserRoleDTO> dtos);
    List<UserRoleSummaryDTO> assembleSummaryDTOsFromEntities(List<UserRoleEntity> entities);
    List<UserRoleSummaryDTO> assembleSummaryDTOsFromDomains(List<UserRole> domains);
    UserRoleSummaryDTO assembleSummaryDTOFromEntity(UserRoleEntity entity);
    UserRoleSummaryDTO assembleSummaryDTOFromDomain(UserRole domain);
    UserRoleEntity assembleEntityFromDomainToSave(int code, RoleEntity role);
}