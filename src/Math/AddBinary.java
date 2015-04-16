package Math;

/**
 * Created by manshu on 4/16/15.
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean carry = false;
        int i = 0;
        while (i < Math.max(a.length(), b.length())) {
            boolean x = false;
            if (i < a.length()) x = a.charAt(a.length() - i - 1) == '1';
            boolean y = false;
            if (i < b.length()) y = b.charAt(b.length() - i - 1) == '1';
            char bit = '0';
            if (carry) {
                if (x && y) {bit = '1'; carry = true;}
                else if (x && !y) {bit = '0'; carry = true;}
                else if (!x && y) {bit = '0'; carry = true;}
                else {bit = '1'; carry = false;}
            }else {
                if (x && y) {bit = '0'; carry = true;}
                else if (x && !y) {bit = '1'; carry = false;}
                else if (!x && y) {bit = '1'; carry = false;}
                else {bit = '0'; carry = false;}
            }
            stringBuilder.append(bit);
            i++;
        }
        if (carry)
            stringBuilder.append('1');
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
