package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by manshu on 1/14/15.
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
        int result[] = new int[2];
        result[0] = -1; result[1] = -1;
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            if (index == null) {
                if (!map.containsKey(numbers[i]))
                    map.put(numbers[i], i);
            } else {
                result[0] = index + 1; result[1] = i + 1;
                return result;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = {2, 7, 11, 15};
        int res[] = twoSum(arr, 17);
        System.out.println(res[0] + ", " + res[1]);
    }
}
