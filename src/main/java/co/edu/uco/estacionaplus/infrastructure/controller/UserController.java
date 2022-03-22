package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.service.serviceuser.*;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final ServiceApplicationSaveUser serviceSaveUser;
    private final ServiceApplicationModifyUser serviceModifyUser;
    private final ServiceApplicationDeleteUser serviceDeleteUser;
    private final ServiceApplicationGetUsers serviceGetUsers;
    private final ServiceApplicationGetUserByCode serviceGetUserByCode;
    private final ServiceApplicationGetUserByEmail serviceGetUserByEmail;

    public UserController(ServiceApplicationSaveUser serviceSaveUser, ServiceApplicationModifyUser serviceModifyUser, ServiceApplicationDeleteUser serviceDeleteUser, ServiceApplicationGetUserByCode serviceGetUserByCode, ServiceApplicationGetUsers serviceGetUsers, ServiceApplicationGetUserByEmail serviceGetUserByEmail)
    {
        this.serviceSaveUser = serviceSaveUser;
        this.serviceModifyUser = serviceModifyUser;
        this.serviceDeleteUser = serviceDeleteUser;
        this.serviceGetUsers = serviceGetUsers;
        this.serviceGetUserByCode = serviceGetUserByCode;
        this.serviceGetUserByEmail = serviceGetUserByEmail;
    }

    @PostMapping
    public ResponseEntity<Response<UserDTO>> save(@RequestBody UserDTO userDTO)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceSaveUser.save(userDTO);

        response.addMessage(UtilMessage.USER_MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    public ResponseEntity<Response<UserDTO>> modify(@RequestBody UserDTO userDTO, @PathVariable int code)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceModifyUser.modify(code, userDTO);

        response.addMessage(UtilMessage.USER_MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Response<UserDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceDeleteUser.delete(code);

        response.addMessage(UtilMessage.USER_MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<Response<UserSummaryDTO>> getAll()
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> response = new Response<>();

        response.setData(this.serviceGetUsers.getAll());
        response.addMessage(UtilMessage.USER_MESSAGE_CONSULTATION_ALL_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Response<UserSummaryDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> respuesta = new Response<>();

        List<UserSummaryDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(UtilMessage.USER_MESSAGE_THE_USER_WITH_CODE + code + UtilMessage.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<Response<UserSummaryDTO>> getByEmail(@PathVariable String email)
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> respuesta = new Response<>();

        List<UserSummaryDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserByEmail.getByEmail(email));
        respuesta.setData(users);

        respuesta.addMessage(UtilMessage.USER_MESSAGE_THE_USER_WITH_EMAIL + email + UtilMessage.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}