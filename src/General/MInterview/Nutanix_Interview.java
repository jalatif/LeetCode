package General.MInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manshu on 3/2/15.
 */
public class Nutanix_Interview {
    private static Set<String> getCombinations(String s) {
        Set<String> set = new HashSet<String>();
        if (s.length() == 0) return set;
        if (s.length() == 1) {
            set.add(s);
            return set;
        }
        // d -> d
        // c -> [c, cd, d]
        // b -> [b, bc, bcd, bd, ..]
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            set.add(String.valueOf(c)); // a
            Set<String> combinations = getCombinations(s.substring(i + 1));
            for (String sc : combinations) {
                set.add(String.valueOf(c) + sc); //
            }
        }
        return set;
    }
    static void printCombinations(String inputStr)
    {
        Set<String> combinations = getCombinations(inputStr);
        for (String s : combinations)
            System.out.println(s);
    }
    
    public static void main(String[] args) {
        printCombinations("abacdc");
    }
}
