package BitManipulation;

/**
 * Created by manshu on 3/10/15.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            int k = n & (1 << i);
            rev = rev << 1;
            if (k == 0) {
                System.out.print("0");
                rev = rev & (0xFFFFFFFE);
            }
            else {
                System.out.print("1");
                rev = rev | 1;
            }
        }
        System.out.println();
        return rev;
    }

    public static void main(String[] args) {
        int k = reverseBits(43261596);
        System.out.println(k);
        System.out.println(reverseBits(k));
    }
}
