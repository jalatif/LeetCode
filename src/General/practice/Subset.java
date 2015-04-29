package General.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 4/24/15.
 */
public class Subset {

    private static List<List<Integer>> subsets(int[] S, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp;

        if (start == S.length) return result;

        for (int i = start; i < S.length; i++) {
            temp = new ArrayList<Integer>();
            temp.add(S[i]);
            List<List<Integer>> ahead = subsets(S, i + 1);
            result.add(temp);
            for (List<Integer> list : ahead) {
                list.add(0, S[i]);
                result.add(list);
            }
        }
        return result;
    }

    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = subsets(S, 0);
        result.add(0, new ArrayList<Integer>());
        return result;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        List<List<Integer>> result = subsets(S);
        for (List<Integer> list : result)
            System.out.println(list);
    }
}
