package Array;

import java.util.Stack;

/**
 * Created by manshu on 3/3/15.
 */
public class ContainerWithMostWater {
    
    public static int maxAreaS(int[] height) {
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int j = i + 1;
            while (j < (height.length - 1) && height[j] < height[i]) j++;
            if (height[j] >= height[i]) {
                int area = (j - i) * (Math.min(height[i], height[j]));
                if (area > max_area) max_area = area;
            } 
        }
        return max_area;
    }
    
    public static int maxArea(int[] height) {
        int max_area = 0;
        int prev_max = 0;
        for (int i = 1; i < height.length; i++) {
            int area = (i - prev_max) * Math.min(height[prev_max], height[i]);
            if (area > max_area) max_area = area;
            if (height[prev_max] < height[i]) {
                prev_max = i;
            }
        }
        return max_area;
    }
    
    public static void main(String[] args) {
        //int height[] = {2, 5, 3, 4, 6, 1, 2, 3, 4, 5};
        int height[] = {1, 2, 1};
        System.out.println(maxAreaS(height));
        System.out.println(maxArea(height));
    }
    
}
