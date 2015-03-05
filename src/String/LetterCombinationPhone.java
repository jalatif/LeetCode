package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by manshu on 3/4/15.
 */
public class LetterCombinationPhone {

    private static Map<String, String> map;

    private static List<String> letterCombinationsUtil(String digits) {
        List<String> list = new ArrayList<String>();

        if (digits == null) return list;
        if (digits.length() == 0) return list;

        String digit = String.valueOf(digits.charAt(0));
        String current = map.get(digit);
        List<String> ahead_list = letterCombinationsUtil(digits.substring(1));

        for (int i = 0; i < current.length(); i++) {
            if (ahead_list.isEmpty())
                list.add(String.valueOf(current.charAt(i)));
            else
                for (String s : ahead_list) {
                    list.add(String.valueOf(current.charAt(i)) + s);
                }
        }

        return list;
    }

    public static List<String> letterCombinations(String digits) {
        map = new HashMap<String, String>();
        map.put("0", " ");
        map.put("1", "");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        return letterCombinationsUtil(digits);

    }

    public static void main(String[] args) {
        String number = "23";
        List<String> comb = letterCombinations(number);
        for (String s : comb) {
            System.out.println(s);
        }
    }
}
