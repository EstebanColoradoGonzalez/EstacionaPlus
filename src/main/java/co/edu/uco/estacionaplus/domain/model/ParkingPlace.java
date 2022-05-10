package co.edu.uco.estacionaplus.domain.model;

import lombok.Getter;

@Getter
public class ParkingPlace
{
    private int code;
    private boolean taken;
    private Place place;

    private ParkingPlace(int code, boolean taken, Place place)
    {
        this.code = code;
        this.taken = taken;
        this.place = place;
    }

    public static ParkingPlace create(int code, boolean taken, Place place)
    {
        return new ParkingPlace(code, taken, place);
    }
}