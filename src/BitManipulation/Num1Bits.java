package BitManipulation;

/**
 * Created by manshu on 3/10/15.
 */
public class Num1Bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        if (n == (Integer.MAX_VALUE + 1)) {
            count = 1;
        }
        while (n > 0) {
            int k = n & ~(n - 1);
            if (k < 0) break;
            n -= k;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
        Long k = Integer.MAX_VALUE + Integer.MAX_VALUE + 1l;
        System.out.println(k.intValue());
    }
}
