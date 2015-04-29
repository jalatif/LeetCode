package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by manshu on 4/22/15.
 */
public class HappyNumbers {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        while (n != 1 && !set.contains(n)) {
            sum = 0;
            set.add(n);
            while (n != 0) {
                int rem = n % 10;
                sum += rem * rem;
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
