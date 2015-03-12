package Math;

/**
 * Created by manshu on 3/11/15.
 */
public class MultiplyStrings {

    private static String add(String num1, String num2) {
        if (num1.equals("")) return num2;
        if (num2.equals("")) return num1;

        StringBuffer result = new StringBuffer();
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        // num2 is shorter
        int n1 = num1.length(), n2 = num2.length();
        int x1, x2, carry = 0;
        for (int i = 0; i < n1; i++) {
            x1 = num1.charAt(n1 - i - 1) - 48;
            if (i < n2)
                x2 = num2.charAt(n2 - i - 1) - 48;
            else
                x2 = 0;
            x1 = x1 + x2 + carry;
            carry = x1 / 10;
            x1 = x1 % 10;
            result.append((char)(x1 + 48));
        }
        if (carry != 0) {
            result.append((char)(carry + 48));
        }
        return result.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "";
        StringBuffer temp;
        int n1 = num1.length(), n2 = num2.length();
        for (int i = 0; i < num2.length(); i++) {
            temp = new StringBuffer();
            for (int k = 0; k < i; k++)
                temp.append('0');
            int carry = 0;
            int x2 = num2.charAt(n2 - i - 1) - 48;
            for (int j = 0; j < num1.length(); j++) {
                int x1 = num1.charAt(n1 - j - 1) - 48;
                x1 = x1 * x2 + carry;
                carry = x1 / 10;
                x1 = x1 % 10;
                temp.append((char)(x1 + 48));
            }
            if (carry != 0) {
                temp.append((char) (carry + 48));
            }
            result = add(result, temp.reverse().toString());
//            System.out.println("Temp - " + temp.toString());
//            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(multiply("123456789", "999999"));
    }
}
