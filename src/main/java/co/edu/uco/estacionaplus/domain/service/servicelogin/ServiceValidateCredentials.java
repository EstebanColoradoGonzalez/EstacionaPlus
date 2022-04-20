package co.edu.uco.estacionaplus.domain.service.servicelogin;

import co.edu.uco.estacionaplus.domain.model.User;
import co.edu.uco.estacionaplus.domain.port.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ServiceValidateCredentials
{
    private final UserRepository userRepository;

    public ServiceValidateCredentials(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String email, String password)
    {
        var users = this.userRepository.getAllWithPassword();
        var usersSelected = new ArrayList<User>();

        if(!users.isEmpty())
        {
            for(int i = 0; i < users.size(); i++)
            {
                if(email.equals(users.get(i).getEmail()))
                {
                    usersSelected.add(users.get(i));
                }
            }
        }

        if(usersSelected.isEmpty())
        {
            return false;
        }

        String hash = usersSelected.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d);

        return argon2.verify(hash, password);
    }
}