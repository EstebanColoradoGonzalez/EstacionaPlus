package co.edu.uco.estacionaplus.infrastructure.aspecto.exception;

public class ExceptionUserUnauthorized extends RuntimeException {

    public static final long serialVersionUID = 1L;
    
    public ExceptionUserUnauthorized(String message) {
        super(message);
    }
}
