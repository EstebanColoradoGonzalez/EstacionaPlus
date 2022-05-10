package co.edu.uco.estacionaplus.infrastructure.aspect.exception;

public class ExceptionUserUnauthorized extends RuntimeException
{
    public static final long serialVersionUID = 1L;
    
    public ExceptionUserUnauthorized(String message)
    {
        super(message);
    }
}