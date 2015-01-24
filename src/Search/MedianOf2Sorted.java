package Search;

/**
 * Created by manshu on 1/22/15.
 */
public class MedianOf2Sorted {
//
//    private static int binarySearch(int A[], int s1, int e1, double target) {
//        int lo = s1;
//        int hi = e1;
//
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//
//            if (A[mid] > ((int) target)) hi = mid - 1;
//            else if (A[mid] < ((int) target)) lo = mid + 1;
//            else return mid;
//        }
////        if (lo == s1) {
////            if (A[lo] <= target) return lo;
////            else return -1;
////        }
////        if (lo == e1) {
////            if (A[lo] >= target) return lo;
////            else return -2;
////        }
////
////        if (A[lo] == target) return lo;
//
//        return lo;
//    }
//    private static double FindMedianSortedArraysUtils(int A[], int s1, int e1, int B[], int s2, int e2) {
//
//        System.out.println(s1 + " " + e1 + "\t\t" + s2 + " " + e2);
//
//        if (s1 == e1 || s2 == e2) return (A[s1] + B[s2]) / 2.0;
//        int median_index1 = s1 + (e1 - s1) / 2;
//        double median1 = A[median_index1];
//
//        int median_index2 = s2 + (e2 - s2) / 2;
//        double median2 = B[median_index2];
//
//        int search_index1 = binarySearch(A, s1, e1, median2);
//        if (search_index1 >= A.length) search_index1 = A.length - 1;
//
//        int search_index2 = binarySearch(B, s2, e2, median1);
//        if (search_index2 >= B.length) search_index2 = B.length - 1;
//
//        System.out.println(median1 + " " + median2 + " " + search_index1 + " " + search_index2);
//
//        if (median1 > median2) {
//            return FindMedianSortedArraysUtils(A, search_index1, median_index1, B, median_index2, search_index2);
//        } else {
//            return FindMedianSortedArraysUtils(A, median_index1, search_index1, B, search_index2, median_index2);
//        }
//
//    }
//
//    public static double FindMedianSortedArrays(int A[], int B[]) {
//        return FindMedianSortedArraysUtils(A, 0, A.length - 1, B, 0, B.length - 1);
//    }





    public static double findMedianSortedArrays(int A[], int B[], int Alo, int Ahi, int Blo, int Bhi) {
        if ((Ahi - Alo + Bhi - Blo) <= 4)
            return (Math.min(A[Ahi], B[Bhi]) + Math.max(A[Alo], B[Blo]) ) / 2;

        int imA = (Ahi - Alo);
        int imB = (Bhi - Blo);
        
        if (imA % 2 != 0) imA = Alo + imA / 2 + 1;
        else              imA = Alo + imA / 2;

        if (imB % 2 != 0) imB = Blo + imB / 2 + 1;
        else              imB = Blo + imB / 2;

        if (A[imA] > B[imB]) {
            return findMedianSortedArrays(A, B, Alo, imA - 1, imB + 1, Bhi);
        } else if (A[imA] < B[imB]) {
            return findMedianSortedArrays(A, B, imA + 1, Ahi, Blo, imB - 1);
        } else {
            return A[imA];
        }
    }
    
    public static double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArrays(A, B, 0 , A.length - 1, 0, B.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {61, 72, 83, 94, 105};
        int arr2[] = {60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230};
        System.out.println(findMedianSortedArrays(arr, arr2));
    }
}
