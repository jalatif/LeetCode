package Greedy;

import java.util.*;

/**
 * Created by manshu on 1/21/15.
 */
public class JumpGame {

//    private static boolean canJump(int[] A, int start) {
//        if (start == A.length - 1) return true;
//        int max_jump = A[start];
//        if (max_jump == 0) return false;
//
//        for (int i = 1; i <= max_jump; i++)
//            if (canJump(A, start + i)) {
//                return true;
//            }
//        return false;
//    }
//
//    private static class Interval {
//        int start;
//        int end;
//        Interval(int s, int e) {
//            start = s; end = e;
//        }
//
//        @Override
//        public String toString() {
//            return "(" + start + ", " + end + ")";
//        }
//    }
//    
//    public static boolean canJump(int[] A) {
//        // Don't land at zero;
//        //System.out.println(canJump(A, 0));
//
//        HashSet<Integer> cache = new HashSet<Integer>();
//        
//        Stack<Interval> stack = new Stack<Interval>();
//        stack.add(new Interval(0, 0));
//        boolean reachable = false;
//        while (!reachable && !stack.isEmpty()) {
//            Interval i = stack.peek();
//            //System.out.println(i);
//            if (i.start > i.end) {
//                stack.pop();
//                continue;
//            }
//            int start = i.end;
//            if (start == A.length - 1) reachable = true;
//            
//            if (i.start == i.end) stack.pop();
//            else i.end--;
//            
//            if (start >= A.length) continue;
//            if (cache.contains(start)) continue;
//            
//            int max_jump = A[start];
//            cache.add(start);
//            
//            Interval new_interval = new Interval(start + 1, start + max_jump);
//            if (!stack.empty() && stack.peek().end > start + 1) stack.peek().end = start - 1;
//            stack.push(new_interval);
//            //System.out.print("Here -> ");
//            //for (Interval iv : stack) System.out.print(iv + " ");
//            //System.out.println();
//        }    
//        return reachable;
//    }


    public static boolean canJump(int[] A) {
        if (A.length == 0) return false;
        
        int reach = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > reach)
                return false;
            reach = Math.max(reach, i + A[i]);
        }
        return true;
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        int arr2[] = {3, 2, 1, 0, 4};
        int arr3[] = new int[100000];
        int arr4[] = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        //Arrays.fill(arr3, 1);
        System.out.println(canJump(arr));
    }
}
