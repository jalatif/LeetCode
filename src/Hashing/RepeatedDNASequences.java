package Hashing;

import java.util.*;

/**
 * Created by manshu on 3/18/15.
 */
public class RepeatedDNASequences {

    private static int convertStringToInt(String s) {
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A': { val |= 0; break;}
                case 'C': { val |= 1; break;}
                case 'G': { val |= 2; break;}
                case 'T': { val |= 3; break;}
                default : {}
            }
            val = val << 2;
        }
        return val;
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            int temp = convertStringToInt(sub);
            if (map.containsKey(temp)) {
                if (map.get(temp) == 1)
                    result.add(s.substring(i, i + 10));
                map.put(temp, map.get(temp) + 1);
                continue;
            }
            map.put(temp, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(s);
        for (String rs : result)
            System.out.println(rs);
    }
}
