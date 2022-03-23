package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import co.edu.uco.estacionaplus.domain.dto.UserRoleSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.UserRole;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;

public interface UserRoleAssembler extends Assembler<UserRole, UserRoleEntity, UserRoleDTO>
{
    UserRoleSummaryDTO assembleSummaryDTOFromEntity(UserRoleEntity entity);
    UserRoleSummaryDTO assembleSummaryDTOFromDomain(UserRole domain);
}