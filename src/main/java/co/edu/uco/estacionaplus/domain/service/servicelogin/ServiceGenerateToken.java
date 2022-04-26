package co.edu.uco.estacionaplus.domain.service.servicelogin;

public interface ServiceGenerateToken
{
    String generateToken(String email, String rol);
}