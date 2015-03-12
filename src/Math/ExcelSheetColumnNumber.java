package Math;

/**
 * Created by manshu on 3/11/15.
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26;
            result += s.charAt(i) - 65 + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}
