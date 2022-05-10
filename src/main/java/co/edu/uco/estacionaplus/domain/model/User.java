package co.edu.uco.estacionaplus.domain.model;

import co.edu.uco.estacionaplus.domain.utilitarian.Message;
import co.edu.uco.estacionaplus.domain.validator.ValidateString;
import lombok.Getter;
import java.util.List;

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
    private List<UserRole> roles;
    private Vehicle vehicle;

    private User(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, List<UserRole> roles, Vehicle vehicle)
    {
        this.code = code;
        setNames(names);
        setLastNames(lastNames);
        setIdentificationNumber(identificationNumber);
        setPhone(phone);
        setEmail(email);
        setPassword(password);
        this.roles = roles;
        this.vehicle = vehicle;
    }

    public static User create(int code, String names, String lastNames, String identificationNumber, String phone, String email, String password, List<UserRole> roles, Vehicle vehicle)
    {
        return new User(code, names, lastNames, identificationNumber, phone, email, password, roles, vehicle);
    }

    private void setNames(String names)
    {
        if (ValidateString.isStringEmpty(names))
        {
            throw new IllegalArgumentException(Message.USER_NAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(names,1, 20))
        {
            throw new IllegalArgumentException(Message.USER_NAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(names))
        {
            throw new IllegalArgumentException(Message.USER_NAME_CHECK_PATTERN);
        }

        this.names = names;
    }

    private void setLastNames(String lastNames)
    {
        if (ValidateString.isStringEmpty(lastNames))
        {
            throw new IllegalArgumentException(Message.USER_LASTNAME_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(lastNames,1, 50))
        {
            throw new IllegalArgumentException(Message.USER_LASTNAME_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringContainsOnlyLettersAndSpaces(lastNames))
        {
            throw new IllegalArgumentException(Message.USER_LASTNAME_CHECK_PATTERN);
        }

        this.lastNames = lastNames;
    }

    private void setIdentificationNumber(String identificationNumber)
    {
        if (ValidateString.isStringEmpty(identificationNumber))
        {
            throw new IllegalArgumentException(Message.USER_IDENTIFICATION_NUMBER_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(identificationNumber,1, 10))
        {
            throw new IllegalArgumentException(Message.USER_IDENTIFICATION_NUMBER_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(identificationNumber))
        {
            throw new IllegalArgumentException(Message.USER_IDENTIFICATION_NUMBER_CHECK_PATTERN);
        }

        this.identificationNumber = identificationNumber;
    }

    private void setPhone(String phone)
    {
        if (ValidateString.isStringEmpty(phone))
        {
            throw new IllegalArgumentException(Message.USER_PHONE_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(phone,1, 10))
        {
            throw new IllegalArgumentException(Message.USER_PHONE_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.isStringAlphanumeric(phone))
        {
            throw new IllegalArgumentException(Message.USER_PHONE_CHECK_PATTERN);
        }

        this.phone = phone;
    }

    private void setEmail(String email)
    {
        if (ValidateString.isStringEmpty(email))
        {
            throw new IllegalArgumentException(Message.USER_EMAIL_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(email,1, 100))
        {
            throw new IllegalArgumentException(Message.USER_EMAIL_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringEmail(email))
        {
            throw new IllegalArgumentException(Message.USER_EMAIL_CHECK_PATTERN);
        }

        this.email = email;
    }

    private void setPassword(String password)
    {
        if (ValidateString.isStringEmpty(password))
        {
            throw new IllegalArgumentException(Message.USER_SECRETWORD_CHECK_STRING_EMPTY);
        }

        if(!ValidateString.isLengthValid(password,1, 255))
        {
            throw new IllegalArgumentException(Message.USER_SECRETWORD_CHECK_LENGTH_VALID);
        }

        if(!ValidateString.stringPassword(password))
        {
            throw new IllegalArgumentException(Message.USER_SECRETWORD_CHECK_PATTERN);
        }

        this.password = password;
    }
}