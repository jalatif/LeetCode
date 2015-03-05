package Search;

import java.util.Arrays;

/**
 * Created by manshu on 2/8/15.
 */
public class FindMinimumSortedRotatedII {
    private static int findMin(int[] num, int lo, int hi) {
        if (lo > hi) return Integer.MAX_VALUE;
        
        if (lo == hi) return num[lo];
        int mid = lo + ((hi - lo) / 2);
        
        if (num[mid] > num[hi]) {
            return findMin(num, mid + 1, hi);
        } else if (num[mid] < num[hi]) {
            return findMin(num, lo, mid);
        } else {
            int lhs = findMin(num, lo, mid);
            int rhs = findMin(num, mid + 1, hi);
            return Math.min(lhs, rhs);
        }
    }
    
    public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public static void main(String[] args) {
        //int arr[] = {11, 4, 5, 6, 7, 8, 9, 10};
        int arr[] = {3, 3, 3, 3, 3, 1, 3, 3, 3, 3};
        System.out.println(findMin(arr));
    }
}
