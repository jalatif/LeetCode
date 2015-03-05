package String;

import java.util.*;

/**
 * Created by manshu on 3/4/15.
 */
public class MinimumWindowString {

    public static String minWindow(String S, String T) {
        int[] required  = new int[256];
        int[] contained = new int[256];
        int chars_required = 0;
        for (int i = 0; i < T.length(); i++) {
            required[T.charAt(i)] += 1;
            if (required[T.charAt(i)] == 1)
                chars_required++;
        }

        int start = -1, end = -1, minStart = -1, minEnd = -1, minLength = S.length() + 1;
        int chars_done = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < S.length(); i++) {
            if (required[S.charAt(i)] == 0) continue;
            else {
                if (start == -1) start = i;
                contained[S.charAt(i)]++;
                if (contained[S.charAt(i)] == required[S.charAt(i)])
                    chars_done++;
                int k = start;
                while (!queue.isEmpty() && contained[S.charAt(k)] > required[S.charAt(k)]) {
                    queue.poll();
                    contained[S.charAt(k)]--;
                    if (queue.isEmpty()) {
                        k = i;
                        break;
                    }
                    k = queue.peek();
                }
                start = k;
                queue.add(i);
                System.out.println("start = " + start + " chars required = " + chars_done);
                if (chars_done == chars_required) {
                    end = i;
                    System.out.println((end - start + 1));
                    if ((end - start + 1) < minLength) {
                        minStart = start; minEnd = end; minLength = end - start + 1;
                    }
                }
            }
        }
        if (minLength == (S.length() + 1)) return "";
        return S.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        S = "baaaabab"; T = "abb";
        System.out.println(minWindow(S, T));
    }
}
