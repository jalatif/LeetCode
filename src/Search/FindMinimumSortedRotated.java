package Search;

import Tree.MaxPathSum;

/**
 * Created by manshu on 1/11/15.
 */
public class FindMinimumSortedRotated {

    public static int findMin(int num[]) {
        int n = num.length;
        if (num[0] < num[n - 1] || n == 1) return num[0];
        int first = 0, last = n - 1;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            System.out.println("First = " + first + ", Last = " + last + ", Mid = " + mid);
            if (mid == first || mid == last) return Math.min(num[first], num[last]);

            if (num[mid] > num[0]) {
                first = mid + 1;
            } else {
                if (num[mid - 1] <= num[mid] && num[mid] <= num[mid + 1])
                    last = mid - 1;
                else
                    return num[mid];
            }
        }
        return num[n - 1];
    }

    public static void main(String args[]) {
        int arr[] = {11, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {10,1,10,10,10};
        int arr3[] = {3, 3, 1};
        System.out.println(findMin(arr3));
    }
}
