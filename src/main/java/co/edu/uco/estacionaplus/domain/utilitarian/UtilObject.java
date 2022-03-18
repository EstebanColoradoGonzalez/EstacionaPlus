package co.edu.uco.estacionaplus.domain.utilitarian;

public class UtilObject
{
    private UtilObject()
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