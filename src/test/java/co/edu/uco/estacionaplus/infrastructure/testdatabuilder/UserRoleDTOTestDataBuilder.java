package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;

public class UserRoleDTOTestDataBuilder
{
    private int code;
    private String name;

    public UserRoleDTOTestDataBuilder()
    {
        this.code = 1;
        this.name = "ROLE_USER";
    }

    public UserRoleDTO build()
    {
        return new UserRoleDTO(code, name);
    }
}