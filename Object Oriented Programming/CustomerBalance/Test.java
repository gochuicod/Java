import java.util.regex.*;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        String sample = "111";
        System.out.println(isNumeric("123"));
        System.out.println(isNumeric("abc"));
        System.out.println(isNumeric("abc123"));

        System.out.println(isAlpha("123"));
        System.out.println(isAlpha("abc"));
        System.out.println(isAlpha("abc123"));

        if (isNumeric(sample)){ System.out.print("It's numeric!"); } else { System.out.print("It's non-numeric!"); }
    }

    private static final Pattern NUMBERS = Pattern.compile("\\d+");
    private static final Pattern LETTERS = Pattern.compile("\\p{Alpha}+");

    public static final boolean isNumeric(String text)
    {
        return NUMBERS.matcher(text).matches();
    }

    public static final boolean isAlpha(String text)
    {
        return LETTERS.matcher(text).matches();
    }
}
