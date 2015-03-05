package Math;

/**
 * Created by manshu on 3/3/15.
 */
public class PailindromeNumber {
    public static boolean isPalindrome(int x) {
        while (x < 0 || x >= 10) {
            int j = 10;
            while (j != 0 && (x / j) != 0) {
                if (j * 10 <= 0) break;
                j *= 10;
            }
            if (j * 10 > 0) j /= 10;

            if (x / j != x % 10) return false;
            x %= j;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-525525));
        System.out.println(isPalindrome(-2147483648));
    }
}
