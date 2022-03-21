package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.UtilText;
import lombok.Getter;

@Getter
public class User
{
    private int code;
    private String names;
    private String lastNames;
    private String identificationNumber;
    private String phone;
    private String email;
    private String password;
    private UserRole userRole;
    private Vehicle vehicle;

    private User(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, UserRole userRole, Vehicle vehicle)
    {
        this.code = code;
        setNames(names);
        setLastNames(lastNames);
        setIdentificationNumber(identificationNumber);
        setPhone(phone);
        setEmail(email);
        setPassword(password);
        this.userRole = userRole;
        this.vehicle = vehicle;
    }

    public static User create(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, UserRole userRole, Vehicle vehicle)
    {
        return new User(code, names, lastNames, identificationNumber, phone, email, password, userRole, vehicle);
    }

    private void setNames(String names)
    {
        if (UtilText.isStringEmpty(names))
        {
            throw new IllegalArgumentException("The names of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(names,1, 20))
        {
            throw new IllegalArgumentException("The names of a User must have a minimum of 1 character and a maximum of 20 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(names))
        {
            throw new IllegalArgumentException("The names of a User can only contain characters.");
        }

        this.names = names;
    }

    private void setLastNames(String lastNames)
    {
        if (UtilText.isStringEmpty(lastNames))
        {
            throw new IllegalArgumentException("The lastNames of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(lastNames,1, 50))
        {
            throw new IllegalArgumentException("The lastNames of a User must have a minimum of 1 character and a maximum of 50 characters.");
        }

        if(!UtilText.stringContainsOnlyLettersAndSpaces(lastNames))
        {
            throw new IllegalArgumentException("The lastNames of a User can only contain characters.");
        }

        this.lastNames = lastNames;
    }

    private void setIdentificationNumber(String identificationNumber)
    {
        if (UtilText.isStringEmpty(identificationNumber))
        {
            throw new IllegalArgumentException("The lastNames of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(identificationNumber,1, 10))
        {
            throw new IllegalArgumentException("The lastNames of a User must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.isStringAlphanumeric(identificationNumber))
        {
            throw new IllegalArgumentException("The lastNames of a User can only contain characters.");
        }

        this.identificationNumber = identificationNumber;
    }

    private void setPhone(String phone)
    {
        if (UtilText.isStringEmpty(phone))
        {
            throw new IllegalArgumentException("The phone of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(phone,1, 10))
        {
            throw new IllegalArgumentException("The phone of a User must have a minimum of 1 character and a maximum of 10 characters.");
        }

        if(!UtilText.isStringAlphanumeric(phone))
        {
            throw new IllegalArgumentException("The phone of a User can only contain characters.");
        }

        this.phone = phone;
    }

    private void setEmail(String email)
    {
        if (UtilText.isStringEmpty(email))
        {
            throw new IllegalArgumentException("The email of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(email,1, 100))
        {
            throw new IllegalArgumentException("The email of a User must have a minimum of 1 character and a maximum of 100 characters.");
        }

        if(!UtilText.stringEmail(email))
        {
            throw new IllegalArgumentException("The email of a User can only contain characters.");
        }

        this.email = email;
    }

    private void setPassword(String password)
    {
        if (UtilText.isStringEmpty(password))
        {
            throw new IllegalArgumentException("The email of a User cannot be empty.");
        }

        if(!UtilText.isLengthValid(password,1, 255))
        {
            throw new IllegalArgumentException("The email of a User must have a minimum of 1 character and a maximum of 255 characters.");
        }

        if(!UtilText.stringPassword(password))
        {
            throw new IllegalArgumentException("The password of a User is incorrect");
        }

        this.password = password;
    }
}