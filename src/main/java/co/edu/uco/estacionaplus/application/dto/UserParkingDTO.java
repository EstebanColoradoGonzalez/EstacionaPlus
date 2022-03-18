package co.edu.uco.estacionaplus.application.dto;

public class UserParkingDTO
{
    private int code;
    private UserDTO user;
    private ParkingDTO parking;

    public UserParkingDTO()
    {

    }

    public UserParkingDTO(int code, UserDTO user, ParkingDTO parking)
    {
        this.code = code;
        this.user = user;
        this.parking = parking;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    public ParkingDTO getParking()
    {
        return parking;
    }

    public void setParking(ParkingDTO parking)
    {
        this.parking = parking;
    }
}