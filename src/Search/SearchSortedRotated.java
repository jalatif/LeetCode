package Search;

/**
 * Created by manshu on 1/11/15.
 */
public class SearchSortedRotated {

    private static int binarySearch(int[] A, int lo, int hi, int target) {
        if (lo < 0 || hi >= A.length) return -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < A[mid])
                hi = mid - 1;
            else if (target > A[mid])
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int search(int[] A, int target) {
        int n = A.length;
        if (A[0] <= A[n - 1]) return binarySearch(A, 0, n - 1, target);
        int first = 0, last = n - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            System.out.println("First = " + first + ", Last = " + last + ", Mid = " + mid);
            if (mid == first) {
                if (target == A[mid]) return mid;
                if (target > A[0]) return binarySearch(A, 0, mid - 1, target );
                else if (target < A[0]) return binarySearch(A, mid + 1, n - 1, target);
                else return 0;
            }
            if (A[mid] > A[0]) {
                first = mid + 1;
            } else {
                if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
                    last = mid - 1;
                else {
                    if (target == A[mid]) return mid;
                    if (target > A[0]) return binarySearch(A, 0, mid - 1, target );
                    else if (target < A[0]) return binarySearch(A, mid + 1, n - 1, target);
                    else return 0;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {11, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {3, 5, 1};
        System.out.println(search(arr2, 1));
    }
}
