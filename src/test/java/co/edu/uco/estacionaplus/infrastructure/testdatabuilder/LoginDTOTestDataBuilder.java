package co.edu.uco.estacionaplus.infrastructure.testdatabuilder;

import co.edu.uco.estacionaplus.application.dto.LoginDTO;

public class LoginDTOTestDataBuilder
{
    private String email;
    private String password;

    public LoginDTOTestDataBuilder()
    {
        this.email = "estebancoloradogonzalez@gmail.com";
        this.password = "123456789Aa";
    }

    public LoginDTO build()
    {
        return new LoginDTO(email, password);
    }
}