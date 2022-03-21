package co.edu.uco.estacionaplus.domain.utilitarian;

public class UtilText
{
    private static final String LETTERS_AND_SPACES_PATTERN = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*$";
    private static final String ALPHANUMERIC_PATTERN = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ .-_+*/#$!=,;?@0123456789]*$";
    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String NIT_PATTERN = "^([0-9]{5,15}-[0-9]{1})?$";
    private static final String SECRET_WORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9]).{8,}$";
    private static final String URL_PATTERN = "^(ftp|http|https):\\/\\/[^ \"]+$";
    public static final String EMPTY = "";

    private UtilText()
    {

    }

    public static boolean stringIsNull(String string)
    {
        return UtilObject.isNull(string);
    }

    public static String getDefaultValue(String string)
    {
        return UtilObject.getDefaultValue(string, "");
    }

    public static String applyTrim(String string)
    {
        return getDefaultValue(string.trim());
    }

    public static boolean isStringEmpty(String string)
    {
        String newString = "";

        if(!stringIsNull(string))
        {
            newString = string;
        }

        return "".equals(applyTrim(newString));
    }

    public static boolean isMinimumLengthValid(String string, int minimumLength)
    {
        return UtilNumber.isNumberGreaterThanOrEqual(applyTrim(string).length(), minimumLength);
    }

    public static boolean isMaximumLengthValid(String string, int maximumLength)
    {
        return applyTrim(string).length() <= maximumLength;
    }

    public static boolean isLengthValid(String string, int minimumLength, int maximumLength)
    {
        return isMinimumLengthValid(string, minimumLength) && isMaximumLengthValid( string, maximumLength);
    }

    public static boolean isStringPatternAccepted(String string, String pattern)
    {
        return applyTrim(string).matches(pattern);
    }

    public static boolean stringContainsOnlyLettersAndSpaces(String string)
    {
        return isStringPatternAccepted(string, LETTERS_AND_SPACES_PATTERN);
    }

    public static boolean isStringAlphanumeric(String string)
    {
        return isStringPatternAccepted(string, ALPHANUMERIC_PATTERN);
    }

    public static boolean stringEmail(String string)
    {
        return isStringPatternAccepted(string, EMAIL_PATTERN);
    }

    public static boolean stringPassword(String string)
    {
        return isStringPatternAccepted(string, SECRET_WORD_PATTERN);
    }

    public static boolean stringNIT(String string)
    {
        return isStringPatternAccepted(string, NIT_PATTERN);
    }

    public static boolean stringURL(String string)
    {
        return isStringPatternAccepted(string, URL_PATTERN);
    }
}