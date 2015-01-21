package Stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by manshu on 1/8/15.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String words[] = path.split("/");
        for (String word : words) {
            if (word.equals("")) continue;
            else if (word.equals(".")) continue;
            else if (word.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(word);
            }
        }
        Iterator<String> iterator = stack.iterator();
        StringBuilder stringBuilder = new StringBuilder("/");
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String args[]) {
        String s = "/a/.//b/../../c/";
        System.out.println(s);
        System.out.println(simplifyPath(s));

    }
}
