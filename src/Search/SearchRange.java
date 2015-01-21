package Search;

/**
 * Created by manshu on 1/12/15.
 */
public class SearchRange {
    public static int[] searchRange(int[] A, int target) {
        int i = 0;
        int n = A.length;
        while (true) {
            int index = (int) Math.pow(2, i++);
            System.out.println(index);
            if (index >= n) break;
            if (A[index] > target) break;
        }
        int last = (int) Math.pow(2, --i);
        last = (last >= n) ? (n-1) : last;
        while (true) {
            int index = (int) Math.pow(2, --i);
            System.out.println(index);
            if (index <= 0) break;
            if (A[index] < target) break;
        }
        int first = (int) Math.pow(2, i);
        System.out.println(first + " " + last);
        int prev = 0;
        int result[] = new int[2];
        result[0] = -1; result[1] = -1;

        for (int k = first; k <= last; k++) {
            if (k != first && A[k] == target) {
                if (A[k - 1] != target) result[0] = k;
            }
            if (k == first && A[k] == target) result[0] = first;

            if (k != last && A[k] == target) {
                if (A[k + 1] != target) result[1] = k;
            }
            if (k == last && A[k] == target) result[1] = last;

        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = {8, 8, 8, 8, 8};
        int A[] = searchRange(arr, 8);
        for (int i : A) System.out.print(i + ", ");
    }
}
