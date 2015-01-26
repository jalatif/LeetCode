package DynamicProgramming;

/**
 * Created by manshu on 1/26/15.
 */
public class MinPathSum {
    
    private static int cache[][];
    
    private static int minPathSum(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == (m - 1) && j == (n - 1)) return grid[i][j];
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        
        if (cache[i][j] != 0) return cache[i][j];
        
        cache[i][j] = grid[i][j] + Math.min(minPathSum(grid, i + 1, j), minPathSum(grid, i, j + 1));
                
        return cache[i][j];
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        cache = new int[m][n];
        
        int a = minPathSum(grid, 0, 0);
        
        System.out.println();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++)
                System.out.print(cache[i][j] + " ");
            System.out.println();
        }
        
        return a;
    }

    public static void main(String[] args) {
        int arr[][] = {
                {1, 4, 2}, 
                {0, 5, 3}, 
                {6, 2, 9},
        };

        System.out.println(minPathSum(arr));
    }
}
