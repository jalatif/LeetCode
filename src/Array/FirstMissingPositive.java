package Array;

/**
 * Created by manshu on 2/5/15.
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length) {
            //System.out.println(i);
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
            else
                i++;

            for (Integer in : A) System.out.print(in + " ");
            System.out.println();
        }
        
        for (int j = 0; j < A.length; j++) {
            if (A[j] != (j + 1))
                return j + 1;
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        int[] arr2 = {3, 1, -1, 21};
        int[] arr = {1};
        System.out.println(firstMissingPositive(arr));
    }
}
