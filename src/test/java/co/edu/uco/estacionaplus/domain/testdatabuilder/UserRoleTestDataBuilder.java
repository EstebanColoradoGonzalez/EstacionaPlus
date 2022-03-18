package co.edu.uco.estacionaplus.domain.testdatabuilder;

import co.edu.uco.estacionaplus.domain.model.UserRole;

public class UserRoleTestDataBuilder
{
    private int code;
    private String name;

    public UserRoleTestDataBuilder()
    {
        this.code = 1;
        this.name = "ROLE_USER";
    }

    public UserRoleTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public UserRoleTestDataBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public UserRole build()
    {
        return UserRole.create(code, name);
    }
}
