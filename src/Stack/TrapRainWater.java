package Stack;

import java.util.Stack;

/**
 * Created by manshu on 1/8/15.
 */
public class TrapRainWater {
    public static int trap(int[] A) {
        if (A.length <= 1) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int prevMax = 0;
        int waterTrapped = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
                prevMax = A[i];
                continue;
            }
            if (A[i] < prevMax) stack.push(A[i]);
            else {
                int val;
                int diff = 0;
                int count = 0;
                while ((val = stack.pop()) != prevMax) {
                    count++;
                    diff += val;
                }
                waterTrapped += count * prevMax;
                waterTrapped -= diff;
                stack.push(A[i]);
                prevMax = A[i];
            }
        }
        if (!stack.empty()) {
            int B[] = new int[stack.size()];
            int i = 0;
            while (!stack.isEmpty()) {
                B[i++] = stack.pop();
            }
            waterTrapped += trap(B);
        }
        return waterTrapped;
    }

    public static void main(String args[]) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 5};
        System.out.println(trap(arr));
    }
}
