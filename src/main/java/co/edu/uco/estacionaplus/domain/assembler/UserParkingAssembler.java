package co.edu.uco.estacionaplus.domain.assembler;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.model.UserParking;
import co.edu.uco.estacionaplus.infrastructure.adapter.entity.UserParkingEntity;

public interface UserParkingAssembler extends Assembler<UserParking, UserParkingEntity, UserParkingDTO>
{
    UserParkingEntity assembleEntityFromDomainToSave(UserParking domain, User user);
    UserParkingEntity assembleEntityFromDomainToModify(int code, UserParking domain);
}