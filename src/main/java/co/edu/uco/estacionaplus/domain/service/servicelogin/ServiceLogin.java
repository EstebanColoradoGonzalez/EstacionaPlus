package co.edu.uco.estacionaplus.domain.service.servicelogin;

import co.edu.uco.estacionaplus.domain.port.UserRepository;
import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceLogin
{
    private final UserRepository userRepository;
    private final ServiceGenerateToken serviceGenerateToken;
    private final ServiceEncryptText serviceEncryptText;

    public ServiceLogin(UserRepository userRepository, ServiceGenerateToken serviceGenerateToken, ServiceEncryptText serviceEncryptText)
    {
        this.userRepository = userRepository;
        this.serviceGenerateToken = serviceGenerateToken;
        this.serviceEncryptText = serviceEncryptText;
    }

    public String validateCredentials(String email, String password)
    {
        var user = this.userRepository.getByEmailWithPassword(email);
        var roles = new ArrayList<String>();
        if(ValidateObject.isNull(user))
        {
            throw new IllegalArgumentException(Message.WRONG_USER_OR_PASSWORD);
        }

        String passwordHashed = user.getPassword();

        if(!passwordHashed.equals(this.serviceEncryptText.encryptText(password)))
        {
            throw new IllegalArgumentException(Message.WRONG_USER_OR_PASSWORD);
        }

        roles.add(user.getUserRole().getName());

        return this.serviceGenerateToken.generateToken(user.getEmail(), roles);
    }
}