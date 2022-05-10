package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.application.service.serviceparking.ServiceApplicationGetParkingByCode;
import co.edu.uco.estacionaplus.application.service.serviceparking.ServiceApplicationGetParkings;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
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
@RequestMapping("/api/parkings")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Parking Controller")
public class ParkingController
{
    private final ServiceApplicationGetParkings serviceGetParkings;
    private final ServiceApplicationGetParkingByCode serviceGetParkingByCode;

    public ParkingController(ServiceApplicationGetParkings serviceGetParkings, ServiceApplicationGetParkingByCode serviceGetParkingByCode)
    {
        this.serviceGetParkings = serviceGetParkings;
        this.serviceGetParkingByCode = serviceGetParkingByCode;
    }

    @GetMapping
    @Operation(summary = "Get All Parking", description = "This is used to get all the parking registered in the application")
    public ResponseEntity<Response<ParkingDTO>> getAll()
    {
        ResponseEntity<Response<ParkingDTO>> responseEntity;
        Response<ParkingDTO> response = new Response<>();

        response.setData(this.serviceGetParkings.getAll());
        response.addMessage(Message.PARKING_MESSAGE_CONSULTATION_ALL_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    @Operation(summary = "Get Parking by Code", description = "This is used to get a parking registered in the application through code")
    public ResponseEntity<Response<ParkingDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<ParkingDTO>> responseEntity;
        Response<ParkingDTO> respuesta = new Response<>();

        List<ParkingDTO> users = new ArrayList<>();
        users.add(this.serviceGetParkingByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(Message.PARKING_MESSAGE_THE_PARKING_WITH_CODE + code + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}
