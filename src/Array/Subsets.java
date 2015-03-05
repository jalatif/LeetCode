package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by manshu on 3/4/15.
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] S, int start) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        
        List<Integer> tmp = new ArrayList<Integer>();
        listList.add(tmp);
        
        if ((S.length - start) == 0) return listList;
        
        for (int i = start; i < S.length; i++) {
            List<List<Integer>> tmp_listList = subsets(S, i + 1);
            for (List<Integer> list : tmp_listList) {
                list.add(S[i]);
                Collections.sort(list);
                listList.add(list);
            }
        }
        
        return listList;
    }
    public static List<List<Integer>> subsets(int[] S) {
        return subsets(S, 0);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> listList = subsets(arr);
        for (List<Integer> list : listList) { 
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
