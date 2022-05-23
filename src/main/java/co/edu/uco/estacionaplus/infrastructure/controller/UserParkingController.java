package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationDeleteUserParking;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationGetUserParkingByCode;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationModifyUserParking;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationSaveUserParking;
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
@RequestMapping("/api/admins")
@Tag(name = "Admin Controller")
public class UserParkingController
{
    private final ServiceApplicationSaveUserParking serviceSaveUserParking;
    private final ServiceApplicationModifyUserParking serviceModifyUserParking;
    private final ServiceApplicationDeleteUserParking serviceDeleteUserParking;
    private final ServiceApplicationGetUserParkingByCode serviceGetUserParkingByCode;

    public UserParkingController(ServiceApplicationSaveUserParking serviceSaveUserParking, ServiceApplicationModifyUserParking serviceModifyUserParking, ServiceApplicationDeleteUserParking serviceDeleteUserParking, ServiceApplicationGetUserParkingByCode serviceGetUserParkingByCode)
    {
        this.serviceSaveUserParking = serviceSaveUserParking;
        this.serviceModifyUserParking = serviceModifyUserParking;
        this.serviceDeleteUserParking = serviceDeleteUserParking;
        this.serviceGetUserParkingByCode = serviceGetUserParkingByCode;
    }

    @PostMapping
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Create Parking", description = "This is used to create a parking and admin in the app")
    public ResponseEntity<Response<UserParkingDTO>> save(@RequestBody UserParkingDTO userParkingDTO)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceSaveUserParking.save(userParkingDTO);

        response.addMessage(Message.ADMIN_MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    @Secured(roles = {"ROLE_ADMIN"})
    @Operation(summary = "Modify Parking", description = "This is used to modify a parking and admin in the app")
    public ResponseEntity<Response<UserParkingDTO>> modify(@RequestBody UserParkingDTO userParkingDTO, @PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceModifyUserParking.modify(code, userParkingDTO);

        response.addMessage(Message.ADMIN_MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    @Secured(roles = {"ROLE_ADMIN"})
    @Operation(summary = "Delete Parking", description = "This is used to delete a parking and admin in the app")
    public ResponseEntity<Response<UserParkingDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceDeleteUserParking.delete(code);

        response.addMessage(Message.ADMIN_MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    @Secured(roles = {"ROLE_ADMIN"})
    @Operation(summary = "Get Admin by Code", description = "This is used to get a parking and admin of the app")
    public ResponseEntity<Response<UserParkingDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> respuesta = new Response<>();

        List<UserParkingDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserParkingByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(Message.ADMIN_MESSAGE_THE_USER_WITH_CODE + code + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}