package co.edu.uco.estacionaplus.application.dto;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRoleDTO
{
    private int code;
    private String name;

    public static UserRoleDTO create()
    {
        return new UserRoleDTO(0, UtilText.EMPTY);
    }
}