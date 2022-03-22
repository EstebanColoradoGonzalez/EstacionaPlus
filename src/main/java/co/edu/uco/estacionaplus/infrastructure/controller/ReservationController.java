package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.application.service.servicereservation.ServiceApplicationDeleteReservation;
import co.edu.uco.estacionaplus.application.service.servicereservation.ServiceApplicationGetReservationByCode;
import co.edu.uco.estacionaplus.application.service.servicereservation.ServiceApplicationModifyReservation;
import co.edu.uco.estacionaplus.application.service.servicereservation.ServiceApplicationSaveReservation;
import co.edu.uco.estacionaplus.infrastructure.controller.response.Response;
import co.edu.uco.estacionaplus.infrastructure.controller.response.enumerator.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController
{
    private static final String MESSAGE_CREATION_SUCCESSFUL = "the reservation was created successful";
    private static final String MESSAGE_MODIFICATION_SUCCESSFUL = "the reservation was modified successful";
    private static final String MESSAGE_ELIMINATION_SUCCESSFUL = "the reservation was removed successful";
    private static final String MESSAGE_THE_USER_WITH_CODE = "the reservation with the code ";
    private static final String MESSAGE_CONSULTATION_SUCCESSFUL = " was consulted successful";

    private final ServiceApplicationSaveReservation serviceSaveReservation;
    private final ServiceApplicationModifyReservation serviceModifyReservation;
    private final ServiceApplicationDeleteReservation serviceDeleteReservation;
    private final ServiceApplicationGetReservationByCode serviceGetReservationByCode;

    public ReservationController(ServiceApplicationSaveReservation serviceSaveReservation, ServiceApplicationModifyReservation serviceModifyReservation, ServiceApplicationDeleteReservation serviceDeleteReservation, ServiceApplicationGetReservationByCode serviceGetReservationByCode)
    {
        this.serviceSaveReservation = serviceSaveReservation;
        this.serviceModifyReservation = serviceModifyReservation;
        this.serviceDeleteReservation = serviceDeleteReservation;
        this.serviceGetReservationByCode = serviceGetReservationByCode;
    }

    @PostMapping
    public ResponseEntity<Response<ReservationDTO>> save(@RequestBody ReservationDTO reservationDTO)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceSaveReservation.save(reservationDTO);

        response.addMessage(MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    public ResponseEntity<Response<ReservationDTO>> modify(@RequestBody ReservationDTO reservationDTO, @PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceModifyReservation.modify(code, reservationDTO);

        response.addMessage(MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Response<ReservationDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceDeleteReservation.delete(code);

        response.addMessage(MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Response<ReservationDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> respuesta = new Response<>();

        List<ReservationDTO> reservations = new ArrayList<>();
        reservations.add(this.serviceGetReservationByCode.getByCode(code));

        respuesta.setData(reservations);

        respuesta.addMessage(MESSAGE_THE_USER_WITH_CODE + code + MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}