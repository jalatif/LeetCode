package Search;

/**
 * Created by manshu on 2/8/15.
 */
public class SearchRotatedArrayII {

    
    private static boolean search(int[] A, int target, int lo, int hi) {
        if (lo > hi) return false;
        
        int mid = lo + (hi - lo) / 2;
        if (A[mid] == target)
            return true;
        
        if (A[mid] > A[hi]) {
            if (A[mid] > target)
                return search(A, target, mid + 1, hi) || search(A, target, lo, mid - 1);
            else if (A[mid] < target)
                return search(A, target, mid + 1, hi);
        } else if (A[mid] < A[hi]) {
            if (A[mid] > target)
                return search(A, target, lo, mid - 1);
            else if (A[mid] < target)
                return search(A, target, lo, mid - 1) || search(A, target, mid + 1, hi);
        }
        return search(A, target, lo, mid - 1) || search(A, target, mid + 1, hi);
    }
    
    public static boolean search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);   // direct for loop should work since O(n)
    }

    public static void main(String[] args) {
        int a[] = {10, 10, 10, 10, 20, 10, 10, 10};
        System.out.println(search(a, 20));
    }
    
}
