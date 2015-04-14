package Math;

/**
 * Created by manshu on 4/10/15.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int[] sum = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            sum[i] = carry + digits[i];
            carry = sum[i] / 10;
            sum[i] = sum[i] % 10;
        }
        if (carry == 1) {
            int[] temp = new int[sum.length + 1];
            for (int i = 0; i < sum.length; i++) {
                temp[i + 1] = sum[i];
            }
            temp[0] = carry;
            sum = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] digits = {1, 1, 2};
        int[] sum = plusOne(digits);
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
        }
    }
}
