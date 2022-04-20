package co.edu.uco.estacionaplus.domain.port;

import co.edu.uco.estacionaplus.domain.dto.UserSummaryDTO;
import co.edu.uco.estacionaplus.domain.model.User;
import java.util.List;

public interface UserRepository
{
    List<UserSummaryDTO> getAll();
    List<User> getAllWithPassword();
    UserSummaryDTO getByCode(int code);
    UserSummaryDTO getByIdentificationNumber(String identificationNumber);
    UserSummaryDTO getByEmail(String email);
    void save(User user);
    void modify(int code, User user);
    void delete(int code);
    boolean exists(UserSummaryDTO user);
}