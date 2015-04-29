package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manshu on 4/25/15.
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        int[] factors = {1, 5, 10, 50, 100, 500, 1000};

        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            for (int i = factors.length - 1; i >= 0; i--) {
                if (factors[i] <= num) {
                    stringBuilder.append(map.get(factors[i]));
                    num -= factors[i];
                    break;
                }
            }
        }

        for (int i = 0; i < stringBuilder.length(); i++) {
            char chr = stringBuilder.charAt(i);
            int j = 1;
            for (j = 1; j < Math.min(4, stringBuilder.length() - i - 1); j++) {
                if (stringBuilder.charAt(i + j) == chr) continue;
                else break;
            }
            if (j == 4) {
                char r = chr;
                for (int f = 0; f < factors.length; f++) {
                    if (r == 1) {
                        r = map.get(factors[f]).charAt(0);
                        break;
                    }
                }
                stringBuilder.replace(i, i + 4, chr + "" + r);
                i += 3;
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(44));
    }
}
