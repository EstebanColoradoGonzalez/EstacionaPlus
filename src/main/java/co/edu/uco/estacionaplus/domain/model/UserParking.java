package co.edu.uco.estacionaplus.domain.model;

import lombok.Getter;

@Getter
public class UserParking
{
    private int code;
    private User user;
    private Parking parking;

    private UserParking(int code, User user, Parking parking)
    {
        this.code = code;
        this.user = user;
        this.parking = parking;
    }

    public static UserParking create(int code, User user, Parking parking)
    {
        return new UserParking(code, user, parking);
    }
}