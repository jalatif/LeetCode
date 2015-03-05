package General;

/**
 * Created by manshu on 2/4/15.
 */
public class DuplicateQuickSort {
    
    private static class Indexes {
        int mid_start;
        int mid_end;
        Indexes(int l, int h) {
            mid_start = l; mid_end = h;
        }

        @Override
        public String toString() {
            return mid_start + "<>" + mid_end;
        }
    }
    
    public static <T extends Comparable<T>> Indexes partition(T[] A, T parition_point, int lo, int hi) {
        //int lo = 0, hi = A.length - 1;
        int mid_start = -1, mid_end = -1;
        
        while (hi >= lo) {
            while (lo <= hi && (A[lo].compareTo(parition_point) <= 0)) {
                if (A[lo].compareTo(parition_point) == 0) {
                    if (mid_start == -1) mid_start = mid_end = lo;
                    else {
                        if (lo == mid_end + 1) mid_end++;
                        else {
                            A[lo] = A[mid_end + 1];
                            A[mid_end + 1] = parition_point;
                            mid_end++;
                        }
                    }
                }
                if (mid_start != -1 && A[lo].compareTo(parition_point) == -1) {
                    A[mid_start++] = A[lo];
                    A[lo] = parition_point;
                    mid_end++;
                }
                lo++;
            }
            if (lo > hi) break;
            
            //System.out.println("Reachable" + lo + " " + hi + " -- " + A[lo] + " " + A[hi]);
            
            while (A[hi].compareTo(parition_point) > 0) {
                hi--;
            }
            if (lo > hi) break;
            
            T temp = A[lo];
            A[lo] = A[hi];
            A[hi] = temp;
        }

        //System.out.println(mid_start + ", " + mid_end);
        
        return new Indexes(mid_start, mid_end);
    }

    public static<T extends Comparable<T>> void quickSort(T[] A, int lo, int hi) {
        if (lo >= hi) return;
        
        Indexes id = partition(A, A[lo], lo, hi);
        quickSort(A, lo, id.mid_start - 1);
        quickSort(A, id.mid_end + 1, hi);

//        System.out.println(id);
//        for (T i : A) System.out.print(i + ", ");
//        id = partition(A, A[lo], lo, id.mid_start - 1);
//        System.out.println(id);
//        for (T i : A) System.out.print(i + ", ");
    }
    
    public static<T extends Comparable<T>> void quickSort(T[] A) {
        quickSort(A, 0, A.length - 1);
    }

    public static<T extends Comparable<T>> boolean isSorted(T[] A) {
        T prev = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i].compareTo(prev) < 0) return false;
            prev = A[i];
        }
        return true;
    }
    
    public static void main(String[] args) {
        Integer[] arr2 = {11, 12, 5, 4, 3, 3, 9, 10, 10, 5, 2, 2, 7, 5, 1, 2, 3};
        Integer[] arr = {10, 5, 5, 5, 5, 5, 5, 5};
        quickSort(arr);
        for (Integer i : arr) System.out.print(i + ", ");
    }
}
