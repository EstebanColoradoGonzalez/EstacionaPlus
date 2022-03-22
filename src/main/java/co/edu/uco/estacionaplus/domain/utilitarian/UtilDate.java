package co.edu.uco.estacionaplus.domain.utilitarian;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate
{
    private static final String DEFAULT_DATE = "2022/01/01";
    private static final String FORMAT_YYYY_MM_DD = "yyyy/mm/dd";

    private UtilDate()
    {

    }

    public static Date getDefaultDate(Date date, Date defaultValue)
    {
        return UtilObject.getDefaultValue(date, defaultValue);
    }

    public static Date getSpecificDate(String date)
    {
        return formatDate(date, FORMAT_YYYY_MM_DD);
    }

    public static Date getCurrentDate()
    {
        return new Date();
    }

    public static Date getDateByDefault()
    {
        return formatDate(DEFAULT_DATE, FORMAT_YYYY_MM_DD);
    }

    public static String getStringDate(Date date)
    {
        return DateFormat.getDateInstance().format(date);
    }

    public static Date formatDate(String textDate, String format)
    {
        try
        {
            SimpleDateFormat formateador = new SimpleDateFormat(format);

            return formateador.parse(textDate);
        }
        catch(ParseException excepcion)
        {
            throw new IllegalArgumentException(excepcion.getMessage());
        }
        catch(Exception excepcion)
        {

            throw new IllegalArgumentException(excepcion.getMessage());
        }
    }
}