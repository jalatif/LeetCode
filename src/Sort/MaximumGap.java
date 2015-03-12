package Sort;

/**
 * Created by manshu on 3/11/15.
 */
public class MaximumGap {
    public static int maximumGap(int[] num) {
        int base = 32;
        int max_diff = 0;

        for (int d = 0; d < base; d++) {
            int[] temp = new int[num.length];
            int[] digit_coll = new int[10];
            for (int i = num.length - 1; i >= 0; i--) {
                int digit = (num[i] / ((int) Math.pow(10, d)) % 10);
                digit_coll[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                digit_coll[i] = digit_coll[i] + digit_coll[i - 1];
            }

            for (int i = num.length - 1; i >= 0; i--) {
                int digit = (num[i] / ((int) Math.pow(10, d)) % 10);
                temp[digit_coll[digit] - 1] = num[i];
                digit_coll[digit]--;
            }
            num = temp;
        }

        for (int i = 0; i < num.length; i++) {
            if (i != 0) {
                if ((num[i] - num[i - 1]) > max_diff)
                    max_diff = num[i] - num[i - 1];
            }
        }

        return max_diff;
    }

    public static void main(String[] args) {
        int[] num = {3, 7, 1, 5, 11};
        System.out.println(maximumGap(num));
    }
}
