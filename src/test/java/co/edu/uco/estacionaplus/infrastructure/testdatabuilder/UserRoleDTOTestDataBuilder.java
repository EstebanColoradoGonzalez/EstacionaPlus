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

    public UserRoleDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public UserRoleDTOTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public UserRoleDTO build()
    {
        return new UserRoleDTO(code, name);
    }
}
