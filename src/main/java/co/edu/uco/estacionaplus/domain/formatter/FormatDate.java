package co.edu.uco.estacionaplus.domain.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate
{
    private static final String FORMAT_YYYY_MM_DD = "yyyy/MM/dd";

    private FormatDate()
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