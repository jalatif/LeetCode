package DynamicProgramming;

/**
 * Created by manshu on 1/26/15.
 */
public class MaxProductSubArray {
    
    private static class Tuple {
        int PmaxProd;
        int NmaxProd;
        public Tuple() {
            PmaxProd = 0;
            NmaxProd = 0;
        }
        public Tuple(int a, int b) {
            PmaxProd = a;
            NmaxProd = b;
        }
    }
    
    private static Tuple maxProduct(int[] A, int lo, int hi) {
        if (lo > hi) return new Tuple();
        if (lo == hi) return new Tuple(A[lo], A[hi]);
        
        int mid = lo + (hi - lo) / 2;
        
        Tuple tuple1 = maxProduct(A, lo, mid);
        Tuple tuple2 = maxProduct(A, mid + 1, hi);
        
        int fp_max_product = 0, fn_max_product = 0;
        
        int prod = 1;
        for (int i = mid; i >= lo; i--) {
            prod *= A[i];
            if (prod > fp_max_product) fp_max_product = prod;
            if (prod < 0 && Math.abs(prod) > Math.abs(fn_max_product)) fn_max_product = prod;
        }
        
        prod = 1;
        int sp_max_product = 0, sn_max_product = 0;
        for (int i = mid + 1; i <= hi; i++) {
            prod *= A[i];
            if (prod > sp_max_product) sp_max_product = prod;
            if (prod < 0 && Math.abs(prod) > Math.abs(sn_max_product)) sn_max_product = prod;
        }
        
        int p_max_product = Math.max(fp_max_product * sp_max_product, fn_max_product * sn_max_product);
        int n_max_product = -1 * Math.max(Math.abs(fp_max_product * sn_max_product), Math.abs(fn_max_product * sp_max_product));
        
        p_max_product = Math.max(Math.max(tuple1.PmaxProd, tuple2.PmaxProd), p_max_product);
        n_max_product = Math.max(Math.max(Math.abs(tuple1.NmaxProd), Math.abs(tuple2.NmaxProd)), Math.abs(n_max_product));

        return new Tuple(p_max_product, -1 * n_max_product);
    }
    public static int maxProduct(int[] A) {
        Tuple tuple = maxProduct(A, 0, A.length - 1);
        System.out.println(tuple.PmaxProd);
        
        int minProd = A[0];
        int maxProd = A[0];
        int result  = A[0];
        for (int i = 1; i < A.length; i++) {
            maxProd = Math.max(Math.max(A[i] * maxProd, A[i] * minProd), A[i]);
            minProd = Math.min(Math.min(A[i] * maxProd, A[i] * minProd), A[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, -5, 4, -1};
        System.out.println(maxProduct(arr));
    }
}
