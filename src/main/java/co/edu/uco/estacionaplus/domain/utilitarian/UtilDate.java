package co.edu.uco.estacionaplus.domain.utilitarian;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilDate
{
    private static final String FORMAT_YYYY_MM_DD = "yyyy/MM/dd";

    private UtilDate()
    {

    }

    public static LocalDate getDate(String textDate)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD);

        return LocalDate.parse(textDate, pattern);
    }

    public static String getStringDate(LocalDate date)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD);

        return pattern.format(date);
    }
}