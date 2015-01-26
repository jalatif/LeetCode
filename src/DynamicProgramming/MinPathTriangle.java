package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by manshu on 1/26/15.
 */
public class MinPathTriangle {
    
    private static List<List<Integer>> cache;

    private static int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        int m = triangle.size();
        if (i >= m || i < 0) return Integer.MAX_VALUE;
        
        int n = triangle.get(i).size();
        if (j >= n || j < 0) return Integer.MAX_VALUE;
        
        if (i == (m - 1)) return triangle.get(i).get(j);
        
        if (cache.get(i).get(j) != 0) return cache.get(i).get(j);
        
        cache.get(i).set(j, triangle.get(i).get(j) + Math.min(minimumTotal(triangle, i + 1, j), minimumTotal(triangle, i + 1, j + 1)));
        
        int result = cache.get(i).get(j);
        //System.out.println(i + ", " + j + " ===> " + result);
        
        return result;
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
//        cache = new ArrayList<List<Integer>>();
//        int m = triangle.size();
//        for (int i = 0; i < m; i++) {
//            cache.add(new ArrayList<Integer>());
//            for (int j = 0; j < triangle.get(i).size(); j++)
//                cache.get(i).add(0);
//        }
//
//        int result = minimumTotal(triangle, 0, 0);
//        System.out.println();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < triangle.get(i).size(); j++)
//                System.out.print(cache.get(i).get(j) + " ");
//            System.out.println();
//        }

        List<Integer> mycache = null;
        List<Integer> prev = null;

        for (int i = 0; i < triangle.size(); i++) {
            mycache = new ArrayList<Integer>();
//            for (int j = 0; j < triangle.get(i).size(); j++) {
//                mycache.add(triangle.get(i).get(j));
//            }

            if (prev == null) {
                prev = mycache;
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    prev.add(triangle.get(i).get(j));
                } 
                continue;
            }

            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) mycache.add(triangle.get(i).get(j) + prev.get(j));
                else if (j == (triangle.get(i).size() - 1)) mycache.add(triangle.get(i).get(j) + prev.get(j - 1));
                else {
                    mycache.add(triangle.get(i).get(j) + Math.min(prev.get(j - 1), prev.get(j)));
                }
            }
            prev = mycache;
        }

        int result2 = Collections.min(prev);

        return result2;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>());
        triangle.add(new ArrayList<Integer>());
        triangle.add(new ArrayList<Integer>());
        triangle.add(new ArrayList<Integer>());

        triangle.get(0).add(2);
        
        triangle.get(1).add(3);
        triangle.get(1).add(4);
        
        triangle.get(2).add(6);
        triangle.get(2).add(5);
        triangle.get(2).add(7);
        
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(minimumTotal(triangle));
    }
}
