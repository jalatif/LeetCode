package Array;

/**
 * Created by manshu on 4/10/15.
 */
public class NextPermutation {

    private static void reverseArray(int[] num, int index) {
        for (int i = 0; i < (num.length - index) / 2; i++) {
            int temp = num[i + index];
            num[i + index] = num[num.length - i - 1];
            num[num.length - i - 1] = temp;
        }
    }

    public static void nextPermutation(int[] num) {
        int pivot = num.length - 2;;
        for (; pivot >= 0; pivot --) {
            if (num[pivot] < num[pivot + 1]) break;
        }
        System.out.println("Pivot = " + pivot);
        if (pivot == -1) {
            reverseArray(num, 0);
        } else {
            int min_index = -1;
            for (int i = pivot + 1; i < num.length; i++) {
                if (num[pivot] < num[i] && (min_index == -1 || num[i] <= num[min_index])) min_index = i;
            }
            int temp = num[pivot];
            num[pivot] = num[min_index];
            num[min_index] = temp;
            reverseArray(num, pivot + 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 5};
        nextPermutation(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
