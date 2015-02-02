package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manshu on 2/1/15.
 */
public class GenerateParanthesis {
    
    private static void generateParenthesis(int index, int left, int right, char str[], List<String> result) {
        if (left < 0 || right < left) return;
        
        if (index == str.length) result.add(new String(str));
        
        if (left > 0) {
            str[index] = '(';
            generateParenthesis(index + 1, left - 1, right, str, result);
        }
        
        if (right > left) {
            str[index] = ')';
            generateParenthesis(index + 1, left, right - 1, str, result);
        }
        
    }
    
    public static List<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        List<String> result = new ArrayList<String>();
        generateParenthesis(0, n, n, str, result);
        return result;
    }
    
    public static void main(String[] args) {
        List<String> parans = generateParenthesis(3);
        for (String s : parans) System.out.println(s);
    }
}
