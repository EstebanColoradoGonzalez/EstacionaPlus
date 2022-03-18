package co.edu.uco.estacionaplus.infrastructure.adapter.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "userrole")
    private UserRoleEntity userRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle")
    private VehicleEntity vehicle;

    public UserEntity()
    {

    }

    public UserEntity(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, UserRoleEntity userRole, VehicleEntity vehicle)
    {
        this.code = code;
        this.names = names;
        this.lastNames = lastNames;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.vehicle = vehicle;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getNames()
    {
        return names;
    }

    public void setNames(String names)
    {
        this.names = names;
    }

    public String getLastNames()
    {
        return lastNames;
    }

    public void setLastNames(String lastNames)
    {
        this.lastNames = lastNames;
    }

    public String getIdentificationNumber()
    {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber)
    {
        this.identificationNumber = identificationNumber;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public UserRoleEntity getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRoleEntity userRole)
    {
        this.userRole = userRole;
    }

    public VehicleEntity getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicle)
    {
        this.vehicle = vehicle;
    }
}