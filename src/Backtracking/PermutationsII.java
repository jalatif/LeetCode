package Backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manshu on 4/15/15.
 */
public class PermutationsII {
    public static Set<List<Integer>> permuteUnique(int[] num, int st) {
        Set<List<Integer>> result = new LinkedHashSet<List<Integer>>();
        int n = num.length - st;
        if (n == 0) return result;
        List<Integer> temp = new ArrayList<Integer>();
        if (n == 1) {
            temp.add(num[st]);
            result.add(temp);
            return result;
        }

        Set<List<Integer>> ahead = permuteUnique(num, st + 1);
        for (List<Integer> list : ahead) {
            for (int i = 0; i <= list.size(); i++) {
                temp = new ArrayList<Integer>(list.size() + 1);
                for (int j = 0; j < i; j++) {
                    temp.add(list.get(j));
                }
                temp.add(num[st]);
                for (int j = i; j < list.size(); j++) {
                    temp.add(list.get(j));
                }
                result.add(temp);
            }
        }
        return result;
    }

    public static List<List<Integer>> permuteUnique(int[] num) {
        Set<List<Integer>> sets = permuteUnique(num, 0);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<Integer> list : sets) {
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(num);
        for (List<Integer> list : result)
            System.out.println(list);
    }
}
