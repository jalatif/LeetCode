package Search;

/**
 * Created by manshu on 1/12/15.
 */
public class RemoveElement {
    public static int removeElement(int[] A, int elem) {
        int n = A.length;
        if (n == 0) return 0;
        int last = n - 1;

        int i = 0;
        while (i <= last){
            if (i == last) { if (A[i] == elem) return last; else break;}
            if (A[i] == elem) {A[i] = A[last]; A[last--] = A[i];continue;}
            i++;
        }
        return last + 1;
    }

    public static void main(String args[]) {
        int arr[] = {5, 3, 1, 2, 1};
        int arr2[] = {1};
        System.out.println(removeElement(arr2, 1));
    }
}
