package co.edu.uco.estacionaplus.domain.utilitarian;

public class UtilNumber
{
    private UtilNumber()
    {

    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T getDefaultNumber(T number)
    {
        return (T) UtilObject.getDefaultValue(number, 0);
    }

    public static <T extends Number> boolean isNumberGreater(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() > getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberLess(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() < getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberTheSame(T number, T comparatorNumber)
    {
        return getDefaultNumber(number).doubleValue() == getDefaultNumber(comparatorNumber).doubleValue();
    }

    public static <T extends Number> boolean isNumberDifferent(T number, T comparatorNumber)
    {
        return !isNumberTheSame(number, comparatorNumber);
    }

    public static <T extends Number> boolean isNumberGreaterThanOrEqual(T number, T comparatorNumber)
    {
        return isNumberGreater(number, comparatorNumber) || isNumberTheSame(number, comparatorNumber);
    }

    public static <T extends Number> boolean isNumberLessThanOrEqual(T number, T comparatorNumber)
    {
        return isNumberLess(number, comparatorNumber) || isNumberTheSame(number, comparatorNumber);
    }

    public static <T extends Number> boolean isNumberBetween(T number, T lowerLimit, T upperLimit)
    {
        return isNumberGreaterThanOrEqual(number, lowerLimit) && isNumberLessThanOrEqual(number, upperLimit);
    }
}