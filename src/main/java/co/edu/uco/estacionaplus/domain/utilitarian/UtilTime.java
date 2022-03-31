package co.edu.uco.estacionaplus.domain.utilitarian;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UtilTime
{
    private static final String FORMAT_HH_MM_SS = "HH:mm:ss";

    private UtilTime()
    {

    }

    public static LocalTime getTime(String textTime)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_HH_MM_SS);

        return LocalTime.parse(textTime, pattern);
    }

    public static String getStringTime(LocalTime time)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_HH_MM_SS);

        return pattern.format(time);
    }
}