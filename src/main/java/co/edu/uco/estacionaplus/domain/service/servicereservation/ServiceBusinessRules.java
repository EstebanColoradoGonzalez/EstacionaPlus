package co.edu.uco.estacionaplus.domain.service.servicereservation;

import co.edu.uco.estacionaplus.domain.model.Price;
import co.edu.uco.estacionaplus.domain.utilitarian.UtilNumber;
import org.springframework.stereotype.Component;

@Component
public class ServiceBusinessRules
{
    public String calculateDepartureTime(String arrivalTime, String typeTime, int value)
    {
        String departureTime = "00:00:00";
        int hours = 0;
        int minutes = 0;

        int finalHour = 0;

        for(var i = 0; i < arrivalTime.length(); i++)
        {
            if(UtilNumber.isNumberTheSame(i, 0))
            {
                hours = concatenateCharacters(i, arrivalTime);
            }

            if(UtilNumber.isNumberTheSame(i, 3))
            {
                minutes = concatenateCharacters(i, arrivalTime);
            }
        }

        if(typeTime.equals("Hora"))
        {
            finalHour = hours + value;
        }

        if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 1)
        {
            departureTime = "0" + finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 1)
        {
            departureTime = finalHour + ":" + "0" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 1 && String.valueOf(minutes).length() == 2)
        {
            departureTime = "0" + finalHour + ":" + minutes + ":00";
        }
        else if (String.valueOf(finalHour).length() == 2 && String.valueOf(minutes).length() == 2)
        {
            departureTime = finalHour + ":" + minutes + ":00";
        }

        return departureTime;
    }

    private static int concatenateCharacters(int index, String arrivalTime)
    {
        return Integer.parseInt("" + arrivalTime.charAt(index) + arrivalTime.charAt(index+1));
    }

    public Price calculatePrice(int arrivalTime)
    {
        return Price.create(0, (double) 2000 * arrivalTime);
    }
}