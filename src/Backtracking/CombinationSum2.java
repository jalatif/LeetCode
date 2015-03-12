package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manshu on 3/11/15.
 */
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] num, int target, int start) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (target < 0) return null;
        if (target == 0) return listList;
        if (start >= num.length) return null;

        boolean targetFound = false;

        List<Integer> temp;

        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) continue;
            List<List<Integer>> result = combinationSum2(num, target - num[i], i + 1);
            if (result == null) continue;
            else if (result.isEmpty()) {
                temp = new ArrayList<Integer>();
                temp.add(num[i]);
                listList.add(temp);
            } else {
                for (List<Integer> list : result) {
                    list.add(0, num[i]);
                    listList.add(list);
                }
            }
            targetFound = true;
        }
        if (targetFound) return listList;
        return null;
    }

    public static List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result = combinationSum2(num, target, 0);
        if (result == null) return new ArrayList<List<Integer>>();
        else return result;
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1};
        List<List<Integer>> result = combinationSum2(candidates, 2);
        for (List<Integer> list : result)
            System.out.println(list);
    }
}
