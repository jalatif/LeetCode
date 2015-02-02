package Array;

/**
 * Created by manshu on 1/31/15.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start_row = 0, end_row = m - 1;
        int start_col = 0, end_col = n - 1;
        
        while (start_row < end_row && start_col < end_col) {
            for (int i = start_row; i < end_row; i++) {
                int s1 = matrix[start_row][i];
                int s2 = matrix[i][end_col];
                int s3 = matrix[end_row][end_col - (i - start_row)];
                int s4 = matrix[end_row - (i - start_row)][start_col];

                matrix[start_row][i] = s4;
                matrix[i][end_col] = s1;
                matrix[end_row][end_col - (i - start_row)] = s2;
                matrix[end_row - (i - start_row)][start_col] = s3;

            }
            start_row++;end_row--;
            start_col++;end_col--;
        }    
    }
    

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%2d", matrix[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6},
                {12, 11, 10, 9, 8, 7},
                {13, 14, 15, 16, 17, 18},
                {24, 23, 22, 21, 20, 19},
                {25, 26, 27, 28, 29, 30}
        };
    
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrix(matrix2);
        System.out.println();
        rotate(matrix2);
        System.out.println();
        printMatrix(matrix2);
    }
}
