package Backtracking;

import java.util.*;

/**
 * Created by manshu on 4/16/15.
 */
public class GrayCode {

    private static Set<Integer> grayCodeSet;
    private static List<Integer> grayCodes;

    private static void grayCode(int num, int n) {
        if (grayCodeSet.contains(num)) return;
        grayCodeSet.add(num);
        grayCodes.add(num);
        for (int i = 0; i < n; i++) {
            int x = num ^ (1 << i);
            if (grayCodeSet.contains(x)) continue;
            grayCode(x, n);
        }
    }
    public static List<Integer> grayCode(int n) {
        grayCodeSet = new HashSet<Integer>();
        grayCodes = new ArrayList<Integer>((int) Math.pow(2, n));
        grayCode(0, n);
        return grayCodes;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}
