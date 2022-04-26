package co.edu.uco.estacionaplus.application.dto;

import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private UserRoleDTO userRole;
    private VehicleDTO vehicle;

    public static UserDTO create()
    {
        return new UserDTO(0, ValidateString.EMPTY, ValidateString.EMPTY, ValidateString.EMPTY, ValidateString.EMPTY, ValidateString.EMPTY, ValidateString.EMPTY, UserRoleDTO.create(), VehicleDTO.create());
    }
}