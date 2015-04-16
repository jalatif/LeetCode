package Array;

import java.util.List;
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

    public static int maxArea(List<Integer> height) {
        int max_area = 0;
        if (height == null || height.size() <= 1) return max_area;
        int i1 = 0; int i2 = height.size() - 1;
        while (i1 < i2) {
            int curr_area = (i2 - i1) * Math.min(height.get(i1), height.get(i2));
            max_area = Math.max(max_area, curr_area);
            if (height.get(i1) <= height.get(i2))
                i1++;
            else
                i2--;
        }
        return max_area;
    }

    public static int maxAreas(int[] height) {
        int max_area = 0;
        int i1 = 0; int i2 = height.length - 1;
        while (i1 < i2) {
            int curr_area = (i2 - i1) * Math.min(height[i1], height[i2]);
            max_area = Math.max(max_area, curr_area);
            if (height[i1] <= height[i2])
                i1++;
            else
                i2--;
        }
        return max_area;
    }
    
    public static void main(String[] args) {
        //int height[] = {2, 5, 3, 4, 6, 1, 2, 3, 4, 5};
        int height[] = {1, 2, 1};
        //System.out.println(maxAreas(height));
        System.out.println(maxAreas(height));
    }
    
}
