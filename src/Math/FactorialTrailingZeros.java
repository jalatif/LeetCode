package Math;

/**
 * Created by manshu on 3/17/15.
 */
public class FactorialTrailingZeros {
    public static int trailingZeroes(int n) {
        int x = 0;
        int val = 5;
        while (val > 0 && val <= n) {
            x += n / val;
            if (Integer.MAX_VALUE / val < 5) break;
            val = val * val;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(2147483647));
    }
}
