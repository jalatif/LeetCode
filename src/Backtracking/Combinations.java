package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 3/10/15.
 */
public class Combinations {

    private static List<List<Integer>> combine(int n, int k, int start) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();

        if (k == 0) return listList;
        if ((start + k - 1) > n) return null;

        List<Integer> temp;
        for (int i = start; i <= n; i++) {
            List<List<Integer>> result = combine(n, k - 1, i + 1);
            if (result == null) continue;
            else if (result.isEmpty()) {
                temp = new ArrayList<Integer>();
                temp.add(i);
                listList.add(temp);
            } else {
                for (List<Integer> list : result) {
                    list.add(0, i);
                    listList.add(list);
                }
            }
        }
        return listList;
    }

    public static List<List<Integer>> combine(int n, int k) {
        return combine(n, k, 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
