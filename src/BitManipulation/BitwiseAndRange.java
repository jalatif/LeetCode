package BitManipulation;

/**
 * Created by manshu on 4/16/15.
 */
public class BitwiseAndRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int x = m ^ n; // get mismatches
        int s = x >> 1;

        while (s != 0) { // from first mismatch high bit make everything 1
            x |= s;
            s = s >> 1;
        }
        return m & n & ~x; // after first mismatch make everything zero.
    }

    public static int rangeBitwiseAndSlow(int m, int n) {
        if (m == 0 || n < m) return 0;
        if (m == n) return n;
        if (m * 2 >= 0  && m * 2 < n ) return 0;
        int result = m;
        for (int number = m; number <= n; number++) {
            result &= number;
            if (number == n || result == 0) break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(20000, Integer.MAX_VALUE));
    }
}
