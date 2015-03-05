package Greedy;

/**
 * Created by manshu on 2/4/15.
 */
public class JumpGame2 {
    public static int jump(int[] A) {
        int max_reach = 0, min_step = 0;
        int last_reach = 0, last_step = 0;
        int current_step = 0;
        
        for (int i = 0; i < A.length; i++) {
            System.out.println(i + " " + max_reach + " " + last_reach);
            if (max_reach >= (A.length - 1)) break;
            if (i > last_reach) {
                if (last_reach == max_reach) return -1;
                last_reach = max_reach;
                last_step = last_step + 1;
                current_step = last_step;
            } 
            
            if ((i + A[i]) > max_reach) {
                max_reach = i + A[i];
                min_step = current_step + 1;
            } 
            
            
        }
        return min_step;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 4};

        System.out.println(jump(arr));
    }
}
