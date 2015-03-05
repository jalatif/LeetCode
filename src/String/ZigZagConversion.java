package String;

/**
 * Created by manshu on 3/3/15.
 */
public class ZigZagConversion {

    public static String convert(String s, int nRows) {
        if (s == null || s.length() == 0) return s;
        if (s.length() <= nRows || nRows == 1) return s;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            int j = i;
            boolean odd = true;
            while (j < s.length()) {
                int ahead = -1;
                if (odd) {
                    odd = false;
                    ahead = 2 * (nRows - 1 - i);
                } else {
                    ahead = 2 * i;
                    odd = true;
                }
                if (ahead != 0)
                    stringBuilder.append(s.charAt(j));
                j += ahead;
            }
        }

        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
