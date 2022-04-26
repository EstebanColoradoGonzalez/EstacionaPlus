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
public class StateDTO
{
    private int code;
    private String name;

    public static StateDTO create()
    {
        return new StateDTO(0, ValidateString.EMPTY);
    }
}