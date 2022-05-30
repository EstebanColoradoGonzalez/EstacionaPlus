package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.dto.UserRoleDTO;
import java.util.ArrayList;
import java.util.List;

public class UserDTOTestDataBuilder
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private List<UserRoleDTOTestDataBuilder> roles;
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
        var role = new UserRoleDTOTestDataBuilder();
        List<UserRoleDTOTestDataBuilder> rolesBuilder = new ArrayList<>();
        rolesBuilder.add(role);
        this.roles = rolesBuilder;
        this.vehicle = new VehicleDTOTestDataBuilder();
    }

    public UserDTO build()
    {
        List<UserRoleDTO> rolesDTO = new ArrayList<>();

        rolesDTO.add(roles.get(0).build());

        return new UserDTO(code, names, lastNames, identificationNumber, phone, email, password, rolesDTO, vehicle.build());
    }
}