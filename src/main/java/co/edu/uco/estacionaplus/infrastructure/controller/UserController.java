package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserDTO;
import co.edu.uco.estacionaplus.application.service.serviceuser.*;
import co.edu.uco.estacionaplus.domain.dto.UserNoSummaryDTO;
import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.infrastructure.aspect.Secured;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller")
public class UserController
{
    private final ServiceApplicationSaveUser serviceSaveUser;
    private final ServiceApplicationModifyUser serviceModifyUser;
    private final ServiceApplicationDeleteUser serviceDeleteUser;
    private final ServiceApplicationGetUsers serviceGetUsers;
    private final ServiceApplicationGetUserByCode serviceGetUserByCode;
    private final ServiceApplicationGetUserByEmail serviceGetUserByEmail;
    private final ServiceApplicationGetUserByEmailWithPassword serviceGetUserByEmailWithPassword;

    public UserController(ServiceApplicationSaveUser serviceSaveUser, ServiceApplicationModifyUser serviceModifyUser, ServiceApplicationDeleteUser serviceDeleteUser, ServiceApplicationGetUserByCode serviceGetUserByCode, ServiceApplicationGetUsers serviceGetUsers, ServiceApplicationGetUserByEmail serviceGetUserByEmail, ServiceApplicationGetUserByEmailWithPassword serviceGetUserByEmailWithPassword)
    {
        this.serviceSaveUser = serviceSaveUser;
        this.serviceModifyUser = serviceModifyUser;
        this.serviceDeleteUser = serviceDeleteUser;
        this.serviceGetUsers = serviceGetUsers;
        this.serviceGetUserByCode = serviceGetUserByCode;
        this.serviceGetUserByEmail = serviceGetUserByEmail;
        this.serviceGetUserByEmailWithPassword = serviceGetUserByEmailWithPassword;
    }

    @PostMapping
    @Operation(summary = "Create User", description = "This is used to create a user in the app")
    public ResponseEntity<Response<UserDTO>> save(@RequestBody UserDTO userDTO)
    {
        ResponseEntity<Response<UserDTO>> responseEntity;
        Response<UserDTO> response = new Response<>();

        serviceSaveUser.save(userDTO);

        response.addMessage(Message.USER_MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Modify User", description = "This is used to modify a user in the app")
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
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Delete User", description = "This is used to delete a user in the app")
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
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get All Users", description = "This is used to get all users of the app")
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
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get User by Code", description = "This is used to get a user of the app through code")
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
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get User by Email", description = "This is used to get a user of the app through email")
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

    @GetMapping("/user/email/{email}")
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get User by Email With Password", description = "This is used to get a user of the app through email")
    public ResponseEntity<Response<UserNoSummaryDTO>> getByEmailWithPassword(@PathVariable String email)
    {
        ResponseEntity<Response<UserNoSummaryDTO>> responseEntity;
        Response<UserNoSummaryDTO> respuesta = new Response<>();

        List<UserNoSummaryDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserByEmailWithPassword.getByEmailWithPassword(email));
        respuesta.setData(users);

        respuesta.addMessage(Message.USER_MESSAGE_THE_USER_WITH_EMAIL + email + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}