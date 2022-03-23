package co.edu.uco.estacionaplus.domain.utilitarian;

public class UtilMessage
{
    private UtilMessage()
    {

    }

    public static final String CITY_NAME_CHECK_STRING_EMPTY = "The name of a City cannot be empty.";
    public static final String CITY_NAME_CHECK_LENGTH_VALID = "The name of a City must have a minimum of 1 character and a maximum of 50 characters.";
    public static final String CITY_NAME_CHECK_PATTERN = "The name of a City can only contain letters and spaces.";

    public static final String PARKING_NIT_CHECK_STRING_EMPTY = "The NIT of a Parking cannot be empty.";
    public static final String PARKING_NIT_CHECK_LENGTH_VALID = "The NIT of a Parking must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String PARKING_NIT_CHECK_PATTERN = "The NIT of a Parking can only contain characters.";
    public static final String PARKING_NAME_CHECK_STRING_EMPTY = "The Name of a Parking cannot be empty.";
    public static final String PARKING_NAME_CHECK_LENGTH_VALID= "The Name of a Parking must have a minimum of 1 character and a maximum of 50 characters.";
    public static final String PARKING_NAME_CHECK_PATTERN = "The Name of a Parking can only contain characters.";
    public static final String PARKING_ADDRESS_CHECK_STRING_EMPTY= "The address of a Parking cannot be empty.";
    public static final String PARKING_ADDRESS_CHECK_LENGTH_VALID = "The address of a Parking must have a minimum of 1 character and a maximum of 50 characters.";
    public static final String PARKING_ADDRESS_CHECK_PATTERN = "The address of a Parking can only contain characters and numbers.";

    public static final String PAYMENTMETHOD_NAME_CHECK_STRING_EMPTY = "The name of a Payment Method cannot be empty.";
    public static final String PAYMENTMETHOD_NAME_CHECK_LENGTH_VALID = "The name of a Payment Method must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String PAYMENTMETHOD_NAME_CHECK_PATTERN = "The name of a Payment Method can only contain letters and spaces.";

    public static final String PLACE_POSITION_CHECK_STRING_EMPTY = "The value of a Place cannot be empty.";
    public static final String PLACE_POSITION_CHECK_LENGTH_VALID = "The value of a Place must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String PLACE_POSITION_CHECK_PATTERN = "The value of a Place can only contain characters.";

    public static final String PRICE_VALUE_CHECK_NUMBER = "The value of a Price cannot be less than or equal to zero.";

    public static final String RESERVATION_ARRIVALTIME_CHECK_STRING_EMPTY = "The arrivalTime of a Reservation cannot be empty.";
    public static final String RESERVATION_ARRIVALTIME_CHECK_LENGTH_VALID = "The arrivalTime of a Reservation must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String RESERVATION_ARRIVALTIME_CHECK_PATTERN = "The arrivalTime of a Reservation can only contain characters.";
    public static final String RESERVATION_DEPARTURETIME_CHECK_STRING_EMPTY = "The departureTime of a Reservation cannot be empty.";
    public static final String RESERVATION_DEPARTURETIME_CHECK_LENGTH_VALID = "The departureTime of a Reservation must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String RESERVATION_DEPARTURETIME_CHECK_PATTERN = "The departureTime of a Reservation can only contain characters.";

    public static final String RESERVEDTIME_VALUE_CHECK_NUMBER = "The value of a ReservedTime cannot be less tan zero.";
    public static final String RESERVEDTIME_TYPETIME_CHECK_STRING_EMPTY = "The type of Time of a ReservedTime cannot be empty.";
    public static final String RESERVEDTIME_TYPETIME_CHECK_LENGTH_VALID = "The type of Time of a ReservedTime must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String RESERVEDTIME_TYPETIME_CHECK_PATTERN = "The type of Time of a ReservedTime can only contain letters and spaces.";

    public static final String STATE_NAME_CHECK_STRING_EMPTY = "The name of a State cannot be empty.";
    public static final String STATE_NAME_CHECK_LENGTH_VALID ="The name of a State must have a minimum of 1 character and a maximum of 50 characters." ;
    public static final String STATE_NAME_CHECK_PATTERN = "The name of a State can only contain letters and spaces.";

    public static final String TYPEPLACE_NAME_CHECK_STRING_EMPTY = "The name of a Type of Place cannot be empty.";
    public static final String TYPEPLACE_NAME_CHECK_LENGTH_VALID = "The name of a Type of Place must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String TYPEPLACE_NAME_CHECK_PATTERN = "The name of a Type of Place can only contain letters and spaces.";

    public static final String TYPEVEHICLE_NAME_CHECK_STRING_EMPTY = "The name of a Type of Vehicle cannot be empty.";
    public static final String TYPEVEHICLE_NAME_CHECK_LENGTH_VALID = "The name of a Type of Vehicle must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String TYPEVEHICLE_NAME_CHECK_PATTERN = "The name of a Type of Vehicle can only contain letters and spaces.";

    public static final String USER_NAME_CHECK_STRING_EMPTY = "The names of a User cannot be empty.";
    public static final String USER_NAME_CHECK_LENGTH_VALID = "The names of a User must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String USER_NAME_CHECK_PATTERN = "The names of a User can only contain characters.";
    public static final String USER_LASTNAME_CHECK_STRING_EMPTY = "The lastNames of a User cannot be empty.";
    public static final String USER_LASTNAME_CHECK_LENGTH_VALID = "The lastNames of a User must have a minimum of 1 character and a maximum of 50 characters.";
    public static final String USER_LASTNAME_CHECK_PATTERN = "The lastNames of a User can only contain characters.";
    public static final String USER_IDENTIFICATION_NUMBER_CHECK_STRING_EMPTY = "The lastNames of a User cannot be empty.";
    public static final String USER_IDENTIFICATION_NUMBER_CHECK_LENGTH_VALID = "The lastNames of a User must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String USER_IDENTIFICATION_NUMBER_CHECK_PATTERN = "The lastNames of a User can only contain characters.";
    public static final String USER_PHONE_CHECK_STRING_EMPTY = "The phone of a User cannot be empty.";
    public static final String USER_PHONE_CHECK_LENGTH_VALID = "The phone of a User must have a minimum of 1 character and a maximum of 10 characters.";
    public static final String USER_PHONE_CHECK_PATTERN = "The phone of a User can only contain characters.";
    public static final String USER_EMAIL_CHECK_STRING_EMPTY = "The email of a User cannot be empty.";
    public static final String USER_EMAIL_CHECK_LENGTH_VALID = "The email of a User must have a minimum of 1 character and a maximum of 100 characters.";
    public static final String USER_EMAIL_CHECK_PATTERN = "The email of a User can only contain characters.";
    public static final String USER_SECRETWORD_CHECK_STRING_EMPTY = "The email of a User cannot be empty.";
    public static final String USER_SECRETWORD_CHECK_LENGTH_VALID = "The email of a User must have a minimum of 1 character and a maximum of 255 characters.";
    public static final String USER_SECRETWORD_CHECK_PATTERN = "The password of a User is incorrect";

    public static final String USERROLE_NAME_CHECK_STRING_EMPTY = "The name of a User Role cannot be empty.";
    public static final String USERROLE_NAME_CHECK_LENGTH_VALID = "The name of a User Role must have a minimum of 1 character and a maximum of 20 characters.";
    public static final String USERROLE_NAME_CHECK_PATTERN = "The name of a User Role can only contain letters and spaces.";

    public static final String VEHICLE_LICENSE_CHECK_STRING_EMPTY = "The license of a Vehicle cannot be empty.";
    public static final String VEHICLE_LICENSE_CHECK_LENGTH_VALID = "The license of a Vehicle must have a minimum of 1 character and a maximum of 6 characters.";
    public static final String VEHICLE_LICENSE_CHECK_PATTERN = "The value of a Vehicle must be alphanumeric.";

    public static final String RESERVATION_MESSAGE_IT_DOES_NOT_EXISTS = "This reservation doesn't exists with this code";
    public static final String MESSAGE_PAYMENT_METHOD_DOES_NOT_EXISTS = "This payment method doesn't exists";
    public static final String MESSAGE_PLACE_IS_TAKEN = "This place was taken by someone else";
    public static final String MESSAGE_USER_DOES_NOT_EXISTS = "This user doesn't exists";
    public static final String MESSAGE_PLACE_DOES_NOT_EXISTS = "This place doesn't exists";

    public static final String USER_MESSAGE_IT_DOES_NOT_EXISTS = "This user doesn't exists with this code";
    public static final String USER_MESSAGE_IT_DOES_NOT_EXISTS_WITH_EMAIL = "This user doesn't exists with this email";
    public static final String MESSAGE_EXISTS_WITH_EMAIL = "There is already someone with this email.";
    public static final String MESSAGE_EXISTS_WITH_IDENTIFICATION_NUMBER = "There is already someone with this identification number.";
    public static final String MESSAGE_USER_ROLE_DOES_NOT_EXISTS_WITH_NAME = "This user role doesn't exists with this name.";
    public static final String MESSAGE_TYPE_VEHICLE_DOES_NOT_EXISTS_WITH_NAME = "This type of vehicle doesn't exists with this name.";
    public static final String MESSAGE_VEHICLE_EXISTS_WITH_LICENSE = "There is already some car with this license.";

    public static final String ADMIN_MESSAGE_IT_DOES_NOT_EXISTS = "This admin doesn't exists with this code";
    public static final String MESSAGE_EXISTS_WITH_NIT = "There is already some parking with this NIT.";
    public static final String MESSAGE_EXISTS_WITH_ADDRESS = "There is already some parking located in this address.";

    public static final String RESERVATION_MESSAGE_CREATION_SUCCESSFUL = "the reservation was created successful";
    public static final String RESERVATION_MESSAGE_MODIFICATION_SUCCESSFUL = "the reservation was modified successful";
    public static final String RESERVATION_MESSAGE_ELIMINATION_SUCCESSFUL = "the reservation was removed successful";
    public static final String RESERVATION_MESSAGE_THE_USER_WITH_CODE = "the reservation with the code ";

    public static final String USER_MESSAGE_CREATION_SUCCESSFUL = "the user was created successful";
    public static final String USER_MESSAGE_MODIFICATION_SUCCESSFUL = "the user was modified successful";
    public static final String USER_MESSAGE_ELIMINATION_SUCCESSFUL = "the user was removed successful";
    public static final String USER_MESSAGE_CONSULTATION_ALL_SUCCESSFUL = "the users was consulted successful";
    public static final String USER_MESSAGE_THE_USER_WITH_CODE = "the user with the code ";
    public static final String USER_MESSAGE_THE_USER_WITH_EMAIL = "the user with the email ";

    public static final String ADMIN_MESSAGE_CREATION_SUCCESSFUL = "the admin was created successful";
    public static final String ADMIN_MESSAGE_MODIFICATION_SUCCESSFUL = "the admin was modified successful";
    public static final String ADMIN_MESSAGE_ELIMINATION_SUCCESSFUL = "the admin was removed successful";
    public static final String ADMIN_MESSAGE_THE_USER_WITH_CODE = "the admin with the code ";

    public static final String MESSAGE_CONSULTATION_SUCCESSFUL = " was consulted successful";

    public static final String AN_ERROR_OCCURRED_PLEASE_CONTACT_THE_ADMINISTRATOR = "An error occurred, please contact the administrator.";
}