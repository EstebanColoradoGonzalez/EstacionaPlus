package co.edu.uco.estacionaplus.domain.testdatabuilder;

import co.edu.uco.estacionaplus.domain.model.User;

public class UserTestDataBuilder
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private UserRoleTestDataBuilder userRole;
    private VehicleTestDataBuilder vehicle;

    public UserTestDataBuilder()
    {
        this.code = 1;
        this.names = "Esteban";
        this.lastNames = "Colorado González";
        this.identificationNumber = "1038418594";
        this.phone = "3228486049";
        this.email = "estebancoloradogonzalez@gmail.com";
        this.password = "123456789Aa";
        this.userRole = new UserRoleTestDataBuilder();
        this.vehicle = new VehicleTestDataBuilder();
    }

    public UserTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public UserTestDataBuilder withNames(String names)
    {
        this.names = names;
        return this;
    }

    public UserTestDataBuilder withLastNames(String lastNames)
    {
        this.lastNames = lastNames;
        return this;
    }

    public UserTestDataBuilder withIdentificationNumber(String identificationNumber)
    {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public UserTestDataBuilder withPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public UserTestDataBuilder withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserTestDataBuilder withPassword(String password)
    {
        this.password = password;
        return this;
    }

    public UserTestDataBuilder withUserRole(UserRoleTestDataBuilder userRole)
    {
        this.userRole = userRole;
        return this;
    }

    public UserTestDataBuilder withVehicle(VehicleTestDataBuilder vehicle)
    {
        this.vehicle = vehicle;
        return this;
    }

    public User build()
    {
        return User.create(code, names, lastNames, identificationNumber, phone, email, password, userRole.build(), vehicle.build());
    }
}
