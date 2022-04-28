package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.LoginDTO;
import co.edu.uco.estacionaplus.application.service.servicelogin.ServiceApplicationLogin;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.infrastructure.aspecto.LogExecutionTime;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController
{
    private final ServiceApplicationLogin serviceLogin;

    public LoginController(ServiceApplicationLogin serviceLogin)
    {
        this.serviceLogin = serviceLogin;
    }

    @PostMapping
    @LogExecutionTime
    public ResponseEntity<Response<String>> login(@RequestBody LoginDTO login)
    {
        ResponseEntity<Response<String>> responseEntity;
        Response<String> response = new Response<>();

        response.setStatus(StatusResponse.SUCCESSFUL);
        response.addMessage(Message.USER_MESSAGE_LOGIN_SUCCESSFUL);

        var respuesta = this.serviceLogin.login(login);
        var list = new ArrayList<String>();
        list.add(respuesta);
        response.setData(list);

        responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        return responseEntity;
    }
}