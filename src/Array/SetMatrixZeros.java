package Array;

/**
 * Created by manshu on 3/4/15.
 */
public class SetMatrixZeros {
    public static void setZeroesS(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row_zero = new boolean[m];
        boolean[] col_zero = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row_zero[i] = true;
                    col_zero[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (row_zero[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;    
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (col_zero[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
    
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero)
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }

        if (firstColZero)
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        
        setZeroes(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
