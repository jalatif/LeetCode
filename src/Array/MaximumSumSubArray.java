package Array;

/**
 * Created by manshu on 1/23/15.
 */
public class MaximumSumSubArray {

    private static int recMaxSubArray(int[] A, int lo, int hi) {
        if (lo > hi) return Integer.MIN_VALUE;
        if (lo == hi) return A[lo];
        
        int mid = lo + (hi - lo) / 2;
        
        int leftSum = recMaxSubArray(A, lo, mid);
        int rightSum = recMaxSubArray(A, mid + 1, hi);
        
        int maxLeftContSum = A[mid], maxRightContSum = A[mid + 1], leftContSum = A[mid], rightContSum = A[mid + 1];
        
        for (int i = mid - 1; i >= lo; i--) {
            leftContSum += A[i];
            if (maxLeftContSum < leftContSum) maxLeftContSum = leftContSum;
        }


        for (int i = mid + 2; i <= hi ; i++) {
            rightContSum += A[i];
            if (maxRightContSum < rightContSum) maxRightContSum = rightContSum;
        }

        return Math.max(Math.max(leftSum, rightSum), maxLeftContSum + maxRightContSum);
        
    }
    
    public static int recMaxSubArray(int[] A) {
        return recMaxSubArray(A, 0, A.length - 1);
    }
    
    public static int maxSubArray(int[] A) {
        if (A.length == 0) return 0;
        
        int maxSum = A[0], currentSum = A[0];
        int ms = 0, me = 0, cs = 0, ce = 0; // current and max start and end
        
        for (int i = 1; i < A.length; i++) {
            if (currentSum < 0) {
                cs = i; ce = i - 1;
                if (maxSum < currentSum) maxSum = currentSum;
                currentSum = 0;
            }
            currentSum += A[i]; ce++;
            if ((maxSum < currentSum) || ((maxSum == currentSum) && (me - ms + 1) < (ce - cs + 1))) {
                maxSum = currentSum;
                ms = cs;
                me = ce;
            } 
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 11, -4, 13, -5, 2};
        int arr2[] = {1, -3, 4, -2, -1, 6};
        
        int arr3[] = {-1, 0, -2};

        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray(arr2));

        System.out.println(recMaxSubArray(arr));
        System.out.println(recMaxSubArray(arr2));

        System.out.println(recMaxSubArray(arr3));
    }
}
