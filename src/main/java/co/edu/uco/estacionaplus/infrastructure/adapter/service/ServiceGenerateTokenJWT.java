package co.edu.uco.estacionaplus.infrastructure.adapter.service;

import co.edu.uco.estacionaplus.domain.service.servicelogin.ServiceGenerateToken;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Component
public class ServiceGenerateTokenJWT implements ServiceGenerateToken
{
    private final Environment environment;

    public ServiceGenerateTokenJWT(Environment environment)
    {
        this.environment = environment;
    }

    @Override
    public String generateToken(String email, String rol)
    {
        return Jwts.builder()
                .setIssuer("EstacionaPlus")
                .setSubject(email)
                .claim("rol", rol)
                .setIssuedAt(createDate(LocalDateTime.now()))
                .setExpiration(createDate(LocalDateTime.now().plusHours(1)))
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(this.environment.getRequiredProperty("token.key")))
                .compact();
    }

    private static Date createDate(LocalDateTime localDateTime)
    {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}