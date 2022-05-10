package co.edu.uco.estacionaplus.infrastructure.aspect.service;

import com.auth0.jwt.JWT;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class AuthorizationService
{
    private final Environment environment;

    public AuthorizationService(Environment environment)
    {
        this.environment = environment;
    }

    public boolean isAuthorized(List<String> rolesToAuthorized)
    {
        String token = getCurrentToken();
        List<String> currentRoles = JWT.decode(getCurrentToken()).getClaim("roles").asList(String.class);
        return hasRole(rolesToAuthorized, currentRoles);
    }

    private boolean hasRole(List<String> rolesToAuthorized, List<String> currentRoles)
    {
        boolean result = false;
        for (String role: rolesToAuthorized)
        {
            if(currentRoles.indexOf(role) != -1)
            {
                result = true;
            }
        }
        return result;
    }

    private String getCurrentToken()
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }
}