package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.ParkingDTO;
import co.edu.uco.estacionaplus.application.service.serviceparking.ServiceApplicationGetParkingByCode;
import co.edu.uco.estacionaplus.application.service.serviceparking.ServiceApplicationGetParkings;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/parkings")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Response<ParkingDTO>> getAll()
    {
        ResponseEntity<Response<ParkingDTO>> responseEntity;
        Response<ParkingDTO> response = new Response<>();

        response.setData(this.serviceGetParkings.getAll());
        response.addMessage(UtilMessage.PARKING_MESSAGE_CONSULTATION_ALL_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Response<ParkingDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<ParkingDTO>> responseEntity;
        Response<ParkingDTO> respuesta = new Response<>();

        List<ParkingDTO> users = new ArrayList<>();
        users.add(this.serviceGetParkingByCode.getByCode(code));

        respuesta.setData(users);

        respuesta.addMessage(UtilMessage.PARKING_MESSAGE_THE_PARKING_WITH_CODE + code + UtilMessage.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}
