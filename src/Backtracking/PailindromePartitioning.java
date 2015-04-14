package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 4/14/15.
 */
public class PailindromePartitioning {

    private static boolean isPailindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null) return result;
        if (s.length() == 0) return result;
        if (s.length() == 1) {
            List<String> temp = new ArrayList<String>();
            temp.add(s);
            result.add(temp);
            return result;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPailindrome(sub)) {
                List<List<String>> out = partition(s.substring(i, s.length()));
                if (out == null) continue;
                if (out.isEmpty() && i != s.length()) continue;
                List<String> temp;
                if (out.isEmpty() && i == s.length()) {
                    temp = new ArrayList<String>();
                    temp.add(sub);
                    result.add(temp);
                    continue;
                }
                for (List<String> list : out) {
                    temp = new ArrayList<String>();
                    temp.add(sub);
                    temp.addAll(list);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aabdbb";
        List<List<String>> result = partition(s);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }
}
