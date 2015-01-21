package Hashing;

import java.util.Hashtable;

/**
 * Created by manshu on 1/14/15.
 */
public class LongestNonRepeatingSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
        int goodStart = 0;
        int goodMax = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = hashtable.get(s.charAt(i));
            hashtable.put(s.charAt(i), i);
            if (index != null) {
                System.out.println(s.charAt(i) + " " + index + " " + i + " " + goodStart);
                if ((i - goodStart) > goodMax) { goodMax = i - goodStart;
                    System.out.println("\t" + index + " " + i + " " + goodStart);}
                if ((index + 1) > goodStart) goodStart = index + 1;
            }
        }
        if ((s.length() - goodStart) > goodMax) goodMax = s.length() - goodStart;
        return goodMax;
    }

    public static void main(String args[]) {
        String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(lengthOfLongestSubstring(s));
        for (int i = 0; i < s.length(); i++) {
            System.out.println(i + " " + s.charAt(i));
        }
    }
}
