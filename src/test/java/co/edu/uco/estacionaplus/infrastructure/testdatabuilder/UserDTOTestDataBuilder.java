package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.UserDTO;

public class UserDTOTestDataBuilder
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private UserRoleDTOTestDataBuilder userRole;
    private VehicleDTOTestDataBuilder vehicle;

    public UserDTOTestDataBuilder()
    {
        this.code = 1;
        this.names = "Esteban";
        this.lastNames = "Colorado González";
        this.identificationNumber = "1038418594";
        this.phone = "3228486049";
        this.email = "estebancoloradogonzalez@gmail.com";
        this.password = "123456789Aa";
        this.userRole = new UserRoleDTOTestDataBuilder();
        this.vehicle = new VehicleDTOTestDataBuilder();
    }

    public UserDTOTestDataBuilder withCode(int code)
    {
        this.code = code;
        return this;
    }

    public UserDTOTestDataBuilder withNames(String names)
    {
        this.names = names;
        return this;
    }

    public UserDTOTestDataBuilder withLastNames(String lastNames)
    {
        this.lastNames = lastNames;
        return this;
    }

    public UserDTOTestDataBuilder withIdentificationNumber(String identificationNumber)
    {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public UserDTOTestDataBuilder withPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public UserDTOTestDataBuilder withEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserDTOTestDataBuilder withPassword(String password)
    {
        this.password = password;
        return this;
    }

    public UserDTOTestDataBuilder withUserRole(UserRoleDTOTestDataBuilder userRole)
    {
        this.userRole = userRole;
        return this;
    }

    public UserDTOTestDataBuilder withVehicle(VehicleDTOTestDataBuilder vehicle)
    {
        this.vehicle = vehicle;
        return this;
    }

    public UserDTO build()
    {
        return new UserDTO(code, names, lastNames, identificationNumber, phone, email, password, userRole.build(), vehicle.build());
    }
}
