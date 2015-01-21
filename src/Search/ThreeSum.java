package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manshu on 1/12/15.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        int n = num.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 3) return result;

        Arrays.sort(num);

        int i, j, target, sum;
        ArrayList<Integer> found;

        int prev = num[0];
        for (int in = 0; in < n; in++) {
            if (in != 0 && prev == num[in]) continue;
            prev = num[in];
            i = in + 1; j = n - 1; target = -1 * num[in];
            int second_entry = num[in];
            //System.out.println("\nSearching for " + target);
            while (i < j) {
                sum = num[i] + num[j];
                //System.out.print("\tSum = " + sum);
                if (sum < target) i += 1;
                else if (sum > target) j -= 1;
                else {
                    if (i != (in + 1) && second_entry == num[i]) {
                        i += 1;
                        continue;
                    }
                    found = new ArrayList<Integer>();
                    found.add(num[in]); found.add(num[i]); found.add(num[j]);
                    result.add(found);
                    second_entry = num[i];
                    i += 1; j -= 1;
                    //System.out.println("\t\tFound" + found);
                }
            }
        }
        return result;
    }


    public static int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n < 3) return -1;
        if (n == 3) return num[0] + num[1] + num[2];

        Arrays.sort(num);

        int j, k, trgt, closestDiff = Integer.MAX_VALUE, prevDiff;
        for (int i = 0; i < n; i++) {
            j = i + 1; k = n - 1; trgt = target - num[i];
            prevDiff = trgt;
            while (j < k) {
                int currentDiff = trgt - (num[j] + num[k]);

                if (j != (i + 1) && k != (n - 1) && Math.abs(prevDiff) < Math.abs(currentDiff)) {
                    break;
                }


                if (Math.abs(currentDiff) < Math.abs(closestDiff)) closestDiff = currentDiff;
                System.out.println(num[i] + ", " + num[j] + ", " + num[k] + ", diff = " + currentDiff + ", " + closestDiff);

                if ((num[j] + num[k]) < trgt) j += 1;
                else if ((num[j] + num[k]) > trgt) k -= 1;
                else return target;
                prevDiff = currentDiff;
            }

            //if (Math.abs(prevDiff) < Math.abs(closestDiff)) closestDiff = prevDiff;
            //System.out.println(num[i] + ", " + num[j] + ", " + num[k] + ", diff = " + prevDiff + ", " + closestDiff);
        }
        return target - closestDiff;
    }

    public static void main(String args[]) {

        int arr[] = {-1, 0, 1, 2, -1, -4};
        int arr2[] = {-2, 0, 0, 2, 2};
        int arr3[] = {1, 1, 1, 1};
        //System.out.println(threeSum(arr2));
        System.out.println(threeSumClosest(arr3, 3));
    }
}
