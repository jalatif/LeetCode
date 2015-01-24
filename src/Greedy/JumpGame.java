package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manshu on 1/21/15.
 */
public class JumpGame {

    private static boolean canJump(int[] A, int start) {
        if (start == A.length - 1) return true;
        int max_jump = A[start];
        if (max_jump == 0) return false;

        for (int i = 1; i <= max_jump; i++)
            if (canJump(A, start + i)) {
                return true;
            }
        return false;
    }

    public static boolean canJump(int[] A) {
        // Don't land at zero;
        return canJump(A, 0);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        int arr2[] = {3, 2, 1, 0, 4};
        int arr3[] = new int[10000];
        Arrays.fill(arr3, 1);
        System.out.println(canJump(arr3));
    }
}
