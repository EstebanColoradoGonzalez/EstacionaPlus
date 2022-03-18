package co.edu.uco.estacionaplus.application.dto;

public class UserDTO
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private UserRoleDTO userRole;
    private VehicleDTO vehicle;

    public UserDTO()
    {

    }

    public UserDTO(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, UserRoleDTO userRole, VehicleDTO vehicle)
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

    public UserRoleDTO getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole)
    {
        this.userRole = userRole;
    }

    public VehicleDTO getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle)
    {
        this.vehicle = vehicle;
    }
}