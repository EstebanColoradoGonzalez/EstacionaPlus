package co.edu.uco.estacionaplus.infrastructure.error;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ErrorManager extends ResponseEntityExceptionHandler
{
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ErrorManager.class);
    private static final ConcurrentHashMap<String, Integer> STATUS_CODES = new ConcurrentHashMap<>();

    public ErrorManager()
    {
        STATUS_CODES.put(IllegalStateException.class.getSimpleName(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception)
    {
        ResponseEntity<Error> result;

        String nameException = exception.getClass().getSimpleName();
        String message = exception.getMessage();
        Integer code = STATUS_CODES.get(nameException);

        if (code != null)
        {
            Error error = new Error(nameException, message);
            result = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        }
        else
        {
            LOGGER_ERROR.error(nameException, exception);
            Error error = new Error(nameException, UtilMessage.AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR);
            result = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
}