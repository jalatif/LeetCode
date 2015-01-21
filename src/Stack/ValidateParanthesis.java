package Stack;

import java.util.Stack;

/**
 * Created by manshu on 1/8/15.
 */
public class ValidateParanthesis {

    private static boolean matchingParanthesis(Character c1, Character c2) {
        if (c1 == '(') {
            if (c2 == ')') return true;
            else return false;
        } else if (c1 == '{') {
            if (c2 == '}') return true;
            else return false;
        } else if (c1 == '[') {
            if (c2 == ']') return true;
            else return false;
        }
        return false;
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) return false;
                Character c = stack.pop();
                if (!matchingParanthesis(c, s.charAt(i))) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]) {
        String s = "(([)])";
        System.out.println(isValid(s));
    }
}
