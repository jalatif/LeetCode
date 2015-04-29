package Math;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by manshu on 4/24/15.
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int[] x = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            x[i] = map.get(String.valueOf(s.charAt(i)));
            System.out.println(x[i]);
        }
        int num = x[0];
        for (int i = 1; i < s.length(); i++) {
            if (x[i] <= x[i - 1])
                num += x[i];
            else {
                num += x[i] - 2 * x[i - 1];
            }
        }

        return num;
    }

    public static void main(String[] args) {
        String s = "XLIX";
        System.out.println(romanToInt(s));
    }
}
