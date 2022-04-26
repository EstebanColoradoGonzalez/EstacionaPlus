package co.edu.uco.estacionaplus.domain.validator;

public class ValidateObject
{
    private ValidateObject()
    {

    }

    public static <T> boolean isNull(T object)
    {
        return object == null;
    }

    public static <T> T getDefaultValue(T object, T defaultValue)
    {
        return isNull(object) ? defaultValue : object;
    }
}