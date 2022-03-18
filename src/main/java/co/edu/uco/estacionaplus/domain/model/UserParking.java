package co.edu.uco.estacionaplus.domain.model;

public class UserParking
{
    private int code;
    private User user;
    private Parking parking;

    private UserParking(int code, User user, Parking parking)
    {
        this.code = code;
        setUser(user);
        setParking(parking);
    }

    public static UserParking create(int code, User user, Parking parking)
    {
        return new UserParking(code, user, parking);
    }

    public int getCode()
    {
        return code;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Parking getParking()
    {
        return parking;
    }

    public void setParking(Parking parking)
    {
        this.parking = parking;
    }
}