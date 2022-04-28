package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.service.serviceuser.*;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.infrastructure.aspecto.SecuredResource;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
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

        int lastIndex = serviceGetUsers.getAll().size() - 1;
        var lastUser = serviceGetUsers.getAll().get(lastIndex);

        userDTO.setCode(lastUser.getCode() + 1);
        userDTO.getVehicle().setCode(lastUser.getVehicle().getCode() + 1);

        serviceSaveUser.save(userDTO);

        response.addMessage(Message.USER_MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    @SecuredResource(name = "USER_ROLE")
    public ResponseEntity<Response<UserDTO>> modify(@RequestBody UserDTO userDTO, @PathVariable int code)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceModifyUser.modify(code, userDTO);

        response.addMessage(Message.USER_MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    @SecuredResource(name = "ROLE_USER")
    public ResponseEntity<Response<UserDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceDeleteUser.delete(code);

        response.addMessage(Message.USER_MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping
    @SecuredResource(name = "ROLE_USER")
    public ResponseEntity<Response<UserSummaryDTO>> getAll()
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> response = new Response<>();

        response.setData(this.serviceGetUsers.getAll());
        response.addMessage(Message.USER_MESSAGE_CONSULTATION_ALL_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    @SecuredResource(name = "ROLE_USER")
    public ResponseEntity<Response<UserSummaryDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> respuesta = new Response<>();

        List<UserSummaryDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(Message.USER_MESSAGE_THE_USER_WITH_CODE + code + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/user/{email}")
    @SecuredResource(name = "ROLE_USER")
    public ResponseEntity<Response<UserSummaryDTO>> getByEmail(@PathVariable String email)
    {
        ResponseEntity<Response<UserSummaryDTO>> responseEntity;
        Response<UserSummaryDTO> respuesta = new Response<>();

        List<UserSummaryDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserByEmail.getByEmail(email));
        respuesta.setData(users);

        respuesta.addMessage(Message.USER_MESSAGE_THE_USER_WITH_EMAIL + email + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}