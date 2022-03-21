package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.UserParkingDTO;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationDeleteUserParking;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationGetUserParkingByCode;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationModifyUserParking;
import co.edu.uco.estacionaplus.application.service.serviceuserparking.ServiceApplicationSaveUserParking;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/userparking")
public class UserParkingController
{
    private static final String MESSAGE_CREATION_SUCCESSFUL = "the admin was created successful";
    private static final String MESSAGE_MODIFICATION_SUCCESSFUL = "the admin was modified successful";
    private static final String MESSAGE_ELIMINATION_SUCCESSFUL = "the admin was removed successful";
    private static final String MESSAGE_THE_USER_WITH_CODE = "the admin with the code ";
    private static final String MESSAGE_CONSULTATION_SUCCESSFUL = " was consulted successful";

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
    public ResponseEntity<Response<UserParkingDTO>> save(@RequestBody UserParkingDTO userParkingDTO)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceSaveUserParking.save(userParkingDTO);

        response.addMessage(MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    public ResponseEntity<Response<UserParkingDTO>> modify(@RequestBody UserParkingDTO userParkingDTO, @PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceModifyUserParking.modify(code, userParkingDTO);

        response.addMessage(MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Response<UserParkingDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> response = new Response<>();

        serviceDeleteUserParking.delete(code);

        response.addMessage(MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Response<UserParkingDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<UserParkingDTO>> responseEntity;
        Response<UserParkingDTO> respuesta = new Response<>();

        List<UserParkingDTO> users = new ArrayList<>();
        users.add(this.serviceGetUserParkingByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(MESSAGE_THE_USER_WITH_CODE + code + MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}