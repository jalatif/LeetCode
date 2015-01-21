package Search;

/**
 * Created by manshu on 1/11/15.
 */
public class SortedRotatedIndex {

    public static int findRotatedIndex(int A[]) {
        int n = A.length;
        if (A[0] < A[n - 1]) return 0;
        int first = 0, last = n - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (mid == first) return (A[first] < A[last]) ? first : last;
            System.out.println("First = " + first + ", Last = " + last + ", Mid = " + mid);
            if (A[mid] > A[0]) {
                first = mid + 1;
            } else {
                if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
                    last = mid - 1;
                else
                    return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {11, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {3, 5, 1};
        System.out.println(findRotatedIndex(arr2));
    }
}
