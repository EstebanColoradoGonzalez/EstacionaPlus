package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.domain.dto.UserNoSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.TypeVehicleEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserEntity;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserRoleEntity;

public interface UserAssembler extends Assembler<User, UserEntity, UserDTO>
{
    UserSummaryDTO assembleSummaryDTOFromEntity(UserEntity entity);
    UserNoSummaryDTO assembleNoSummaryDTOFromEntity(UserEntity entity);
    UserSummaryDTO assembleSummaryDTOFromDomain(User domain);
    UserEntity assembleEntityFromDomainToSave(User domain, UserRoleEntity userRole, TypeVehicleEntity typeVehicle);
    UserEntity assembleEntityFromDomainToModify(int code, User domain);
}