package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.service.servicelogin.ServiceApplicationValidateCredentials;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController
{
    private final ServiceApplicationValidateCredentials serviceValidateCredentials;

    public LoginController(ServiceApplicationValidateCredentials serviceValidateCredentials)
    {
        this.serviceValidateCredentials = serviceValidateCredentials;
    }

    @PostMapping
    public ResponseEntity<Response<UserDTO>> validateUser(@RequestBody UserDTO user)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        var userDTO = UserDTO.create();

        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        if(this.serviceValidateCredentials.validateCredentials(userDTO))
        {
            response.addMessage(UtilMessage.USER_MESSAGE_LOGIN_SUCCESSFUL);
        }
        else
        {
            response.addMessage(UtilMessage.USER_MESSAGE_LOGIN_NOT_SUCCESSFUL);
        }

        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}