package DynamicProgramming;

import java.util.Comparator;

/**
 * Created by manshu on 1/27/15.
 */
public class MaximumRectangleArea {

    public static class point2d implements Comparable<point2d> {
        int x;
        int y;
        public point2d(int a, int b) {
            x = a; y = b;
        }
        
        public int area(){
            return this.x * this.y;
        }
        
        @Override
        public int compareTo(point2d o) {
            Integer i1 = this.x * this.y;
            Integer i2 = o.x * o.y;
            return i1.compareTo(i2);
        }
    }
    
    private static point2d cache[][];
    
    public static int maximalRectangle(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        cache = new point2d[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                point2d p1;
                if ((j - 1) >= 0)
                    p1 = cache[i][j - 1]; //  .<-    .
                else
                    p1 = new point2d(0, 0);
                
                point2d p2;
                if ((i - 1) >= 0) 
                    p2 = cache[i-1][j]; //    .^
                else
                    p2 = new point2d(0, 0);

                point2d p3 = new point2d(0, 0);
                if ((i - 1) >= 0)
                    if ((j - 1) >= 0)
                        p3 = cache[i-1][j-1];

                if (matrix[i][j] == 0) {
                    cache[i][j] = new point2d(0, 0); 
                    continue;
                }
                if (p1.x == 0)
                    cache[i][j] = new point2d(1, 1 + p2.y);
                else if (p2.y == 0) cache[i][j] = new point2d(1 + p1.x, 1);
                else {
                    point2d np;
                    int area = 0;
                    np = new point2d(Math.min(p3.x, p1.x) + 1, Math.min(p3.y, p2.y) + 1);
                    area = (np.x + 1) * (np.y + 1);
                    if ((1 * (p2.y + 1)) > area) {
                        area = 1 * (p2.y + 1);
                        np = new point2d(1, p2.y + 1);
                    }
                    if ((1 * (p1.x + 1)) > area) {
                        area = 1 * (p1.x + 1);
                        np = new point2d(p1.x + 1, 1);
                    }
                    cache[i][j] = np;
                }
            }
        
        int maxArea = 0;
        for (int i = 0; i < m; i++){
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(cache[i][j].x + "," + cache[i][j].y + " ");
                if (cache[i][j].area() > maxArea) maxArea = cache[i][j].area();
            }
        }
        System.out.println();
        return maxArea;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
        };

        System.out.println(maximalRectangle(matrix));
    }
}
