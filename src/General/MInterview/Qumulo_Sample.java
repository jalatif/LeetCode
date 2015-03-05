package General.MInterview;

/**
 * Created by manshu on 2/25/15.
 */
import java.io.*;

public class Qumulo_Sample {

    private static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
            
        }
        return true;
    }
    
    public static int getNumberOfPrimesSlow(int N) {
        int count = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime(i)) count++;
        }    
        
        return count;
    }
    
    public static int getNumberOfPrimes(int N) {
        boolean[] marked = new boolean[N];
        for (int i = 2; i < N; i++) {
            if (marked[i]) continue;
            int j = i * i;
            while ((i * j) < N && (i * j) > 2) {
                marked[i * j] = true;
                j++;
            }
        }
        int count = 0;
        for (int i = 2; i < N; i++) {
            if (!marked[i]) count++;
        }
        return count;
    }    
    
    public static void main(String[] args) {
        System.out.println(getNumberOfPrimes(78498));
    }
    
//    public static int findMissingInAP(int[] A) {
//        if (A.length == 0) return -1;
//        if (A.length == 1) return -1;
//        if (A.length == 2) return A[1] + (A[1] - A[0]);
//        
//        int d = A[1] - A[0];
//        int sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            sum += A[i];
//        }
//        int correct_sum = (A.length + 1) * (A[A.length - 1] + A[0]);
//        correct_sum = correct_sum / 2;
//        return correct_sum - sum;
//        
////        for (int i = 1; i < (A.length - 1); i++) {
////            int temp_d = A[i + 1] - A[i];
////            
////        }
//    }
//    
//    public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        String[] arr = br.readLine().split(" ");
//        int[] A = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            A[i] = Integer.parseInt(arr[i]);
//        }
//        //int A[] = {1, 3, 5, 9, 11};
//        System.out.println(findMissingInAP(A));    
//    }
}