package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manshu on 3/11/15.
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (target < 0) return null;
        if (target == 0) return listList;
        if (start >= candidates.length) return null;

        boolean targetFound = false;

        List<Integer> temp;

        for (int i = start; i < candidates.length; i++) {
            List<List<Integer>> result = combinationSum(candidates, target - candidates[i], i);
            if (result == null) continue;
            else if (result.isEmpty()) {
                temp = new ArrayList<Integer>();
                temp.add(candidates[i]);
                listList.add(temp);
            } else {
                for (List<Integer> list : result) {
                    list.add(0, candidates[i]);
                    listList.add(list);
                }
            }
            targetFound = true;
        }
        if (targetFound) return listList;
        return null;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = combinationSum(candidates, target, 0);
        if (result == null) return new ArrayList<List<Integer>>();
        else return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(candidates, 7);
        for (List<Integer> list : result)
            System.out.println(list);
    }
}
