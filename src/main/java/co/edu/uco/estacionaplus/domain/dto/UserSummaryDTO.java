package co.edu.uco.estacionaplus.domain.dto;

public class UserSummaryDTO
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private UserRoleSummaryDTO userRole;
    private VehicleSummaryDTO vehicle;

    public UserSummaryDTO()
    {

    }

    public UserSummaryDTO(int code, String names, String lastNames, String identificationNumber, String phone, String email, UserRoleSummaryDTO userRole, VehicleSummaryDTO vehicle)
    {
        this.code = code;
        this.names = names;
        this.lastNames = lastNames;
        this.identificationNumber = identificationNumber;
        this.phone = phone;
        this.email = email;
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

    public UserRoleSummaryDTO getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRoleSummaryDTO userRole)
    {
        this.userRole = userRole;
    }

    public VehicleSummaryDTO getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(VehicleSummaryDTO vehicle)
    {
        this.vehicle = vehicle;
    }
}