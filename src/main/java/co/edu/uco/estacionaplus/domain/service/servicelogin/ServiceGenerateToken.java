package co.edu.uco.estacionaplus.domain.service.servicelogin;

import java.util.List;

public interface ServiceGenerateToken
{
    String generateToken(String email, List<String> roles);
}