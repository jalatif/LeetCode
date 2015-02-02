package Array;

/**
 * Created by manshu on 1/31/15.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        int prev = A[0];
        int count = 1;
        int j = 1, i = 1;
        while (i < n) {
            if (A[i] == prev) {
                i++;
                count++;
                if (count == 2) A[j++] = prev;
            }
            else {
                A[j++] = A[i];
                prev = A[i];
                i++;
                count = 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
        for (Integer i : arr) System.out.print(i + " ");
    }
}
