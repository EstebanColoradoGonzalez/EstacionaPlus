package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class VehicleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private String license;
    @ManyToOne
    @JoinColumn(name = "typevehicle")
    private TypeVehicleEntity typeVehicle;

    public VehicleEntity()
    {

    }

    public VehicleEntity(int code, String license, TypeVehicleEntity typeVehicle)
    {
        this.code = code;
        this.license = license;
        this.typeVehicle = typeVehicle;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    public TypeVehicleEntity getTypeVehicle()
    {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicleEntity typeVehicle)
    {
        this.typeVehicle = typeVehicle;
    }
}