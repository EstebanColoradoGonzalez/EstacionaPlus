package co.edu.uco.estacionaplus.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserSummaryDTO
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private List<UserRoleSummaryDTO> roles;
    private VehicleSummaryDTO vehicle;
}