package Sort;

/**
 * Created by manshu on 1/12/15.
 */
public class SortColors {
    public static void sortColors(int[] A) {
        int k = 3;
        int n = A.length;
        int C[] = new int[k];
        for (int i = 0; i < k; i++)
            C[i] = 0;
        for (int i = 0; i < n; i++)
            C[A[i]] += 1;
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (C[i] > 0) {
                A[index++] = i;
                C[i]--;
            }
        }

    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 0, 0, 2, 1, 2, 1, 0, 1, 1, 0};
        sortColors(arr);
        for (int i : arr) System.out.print(i + ", ");
    }
}
