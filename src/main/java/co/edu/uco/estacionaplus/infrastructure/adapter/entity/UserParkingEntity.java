package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

public class UserParkingEntity
{
    private int code;
    private UserEntity user;
    private ParkingEntity parking;

    public UserParkingEntity()
    {

    }

    public UserParkingEntity(int code, UserEntity user, ParkingEntity parking)
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

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public ParkingEntity getParking()
    {
        return parking;
    }

    public void setParking(ParkingEntity parking)
    {
        this.parking = parking;
    }
}