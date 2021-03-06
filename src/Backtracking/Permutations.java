package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 3/11/15.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] num, int st) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = num.length - st;
        if (n == 0) return result;
        List<Integer> temp = new ArrayList<Integer>();
        if (n == 1) {
            temp.add(num[st]);
            result.add(temp);
            return result;
        }

        List<List<Integer>> ahead = permute(num, st + 1);
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

    public static List<List<Integer>> permute(int[] num) {
        return permute(num, 0);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        List<List<Integer>> result = permute(num);
        for (List<Integer> list : result)
            System.out.println(list);
    }
}
