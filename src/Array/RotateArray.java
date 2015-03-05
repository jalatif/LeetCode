package Array;

/**
 * Created by manshu on 2/28/15.
 */
public class RotateArray {
    
    private static void swapK(int[] nums, int i1, int j1, int i2, int j2) {
        if ((j1 - i1) != (j2 - i2)) return;
        for (int i = 0; i <= (j1 - i1); i++) {
            nums[i1 + i] = nums[i1 + i] ^ nums[i2 + i];
            nums[i2 + i] = nums[i1 + i] ^ nums[i2 + i];
            nums[i1 + i] = nums[i1 + i] ^ nums[i2 + i];
        }
    }
    public static void leftRotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        if (k == 0) return;

        for (int i = n - k; i >= k ; i -= k) {
            swapK(nums, 0, k - 1, i, i + k - 1);
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void rightRotate(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        if (k == 0) return;
        
        for (int i = 0; i < (n - k); i += k) {
            swapK(nums, i, i + k - 1, n - k, n - 1);
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotater(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k > n / 2) leftRotate(nums, n - k);
        else rightRotate(nums, k);
        
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        k = n - k;
        int arr[] = new int[n];
        
        
        for (int i = k; i < n; i++)
            arr[i - k] = nums[i];
        for (int i = 0; i < k; i++)
            arr[n - k + i] = nums[i];
        
        for (int i = 0; i < n; i++)
            nums[i] = arr[i];
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        rotate(arr, 6);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}