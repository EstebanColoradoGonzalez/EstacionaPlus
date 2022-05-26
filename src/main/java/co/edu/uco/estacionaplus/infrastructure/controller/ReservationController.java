package co.edu.uco.estacionaplus.infrastructure.controller;

import co.edu.uco.estacionaplus.application.dto.ReservationDTO;
import co.edu.uco.estacionaplus.application.service.servicereservation.*;
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
@RequestMapping("/api/reservation")
@CrossOrigin("http://localhost:4200")
@Tag(name = "Reservation Controller")
public class ReservationController
{
    private final ServiceApplicationSaveReservation serviceSaveReservation;
    private final ServiceApplicationModifyReservation serviceModifyReservation;
    private final ServiceApplicationDeleteReservation serviceDeleteReservation;
    private final ServiceApplicationGetReservationByCode serviceGetReservationByCode;
    private final ServiceApplicationGetReservations serviceGetReservations;

    public ReservationController(ServiceApplicationSaveReservation serviceSaveReservation, ServiceApplicationModifyReservation serviceModifyReservation, ServiceApplicationDeleteReservation serviceDeleteReservation, ServiceApplicationGetReservationByCode serviceGetReservationByCode, ServiceApplicationGetReservations serviceGetReservations)
    {
        this.serviceSaveReservation = serviceSaveReservation;
        this.serviceModifyReservation = serviceModifyReservation;
        this.serviceDeleteReservation = serviceDeleteReservation;
        this.serviceGetReservationByCode = serviceGetReservationByCode;
        this.serviceGetReservations = serviceGetReservations;
    }

    @PostMapping
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Create a Reservation", description = "This is used to make a reservation in a place of a specific parking")
    public ResponseEntity<Response<ReservationDTO>> save(@RequestBody ReservationDTO reservationDTO)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceSaveReservation.save(reservationDTO);

        response.addMessage(Message.RESERVATION_MESSAGE_CREATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("/{code}")
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Modify a Reservation", description = "This is used to modify a reservation of a place of a specific parking")
    public ResponseEntity<Response<ReservationDTO>> modify(@RequestBody ReservationDTO reservationDTO, @PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceModifyReservation.modify(code, reservationDTO);

        response.addMessage(Message.RESERVATION_MESSAGE_MODIFICATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{code}")
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Delete a Reservation", description = "This is used to delete a reservation of a place of a specific parking")
    public ResponseEntity<Response<ReservationDTO>> delete(@PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> response = new Response<>();

        serviceDeleteReservation.delete(code);

        response.addMessage(Message.RESERVATION_MESSAGE_ELIMINATION_SUCCESSFUL);
        response.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(response, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/{code}")
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get Reservation by Code", description = "This is used to get a reservation of a place of a specific parking through code")
    public ResponseEntity<Response<ReservationDTO>> getByCode(@PathVariable int code)
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> respuesta = new Response<>();

        List<ReservationDTO> reservations = new ArrayList<>();
        reservations.add(this.serviceGetReservationByCode.getByCode(code));

        respuesta.setData(reservations);

        respuesta.addMessage(Message.RESERVATION_MESSAGE_THE_USER_WITH_CODE + code + Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping
    @Secured(roles = {"ROLE_USER"})
    @Operation(summary = "Get All Reservations", description = "This is used to get all the reservations")
    public ResponseEntity<Response<ReservationDTO>> getAll()
    {
        ResponseEntity<Response<ReservationDTO>> responseEntity;
        Response<ReservationDTO> respuesta = new Response<>();

        var reservations = this.serviceGetReservations.getReservations();

        respuesta.setData(reservations);

        respuesta.addMessage(Message.MESSAGE_CONSULTATION_SUCCESSFUL);
        respuesta.setStatus(StatusResponse.SUCCESSFUL);

        responseEntity = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);

        return responseEntity;
    }
}