package Array;

import java.util.*;

/**
 * Created by manshu on 4/16/15.
 */
public class SubsetsII {

    public static Set<List<Integer>> subsetsWithDup(int[] S, int start) {
        Set<List<Integer>> listList = new LinkedHashSet<List<Integer>>();

        List<Integer> tmp = new ArrayList<Integer>();
        listList.add(tmp);

        if ((S.length - start) == 0) return listList;

        for (int i = start; i < S.length; i++) {
            Set<List<Integer>> tmp_listList = subsetsWithDup(S, i + 1);
            for (List<Integer> list : tmp_listList) {
                list.add(S[i]);
                Collections.sort(list);
                listList.add(list);
            }
        }

        return listList;
    }

    public static List<List<Integer>> subsetsWithDup(int[] S) {
        Set<List<Integer>> set = subsetsWithDup(S, 0);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (List<Integer> list : set) {
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> listList = subsetsWithDup(arr);
        for (List<Integer> list : listList) {
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
