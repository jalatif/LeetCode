package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 2/1/15.
 */
public class NQueens2 {

    private static int placements;
    
    private static boolean checkValidPlacement(int rowI, int colI, int[] column_placements, int n) {
        for (int row = 0; row < rowI; row++) {
            int col = column_placements[row];

            if (col == colI) return false;

            int row_shift = rowI - row;
            int col_shift = Math.abs(colI - col);

            if (col_shift == row_shift) return false;
        }
        return true;
    }

    private static void totalNQueens(int row, int[] column_placements, int n) {

        if (row == n) {
            placements++;
        }
        for (int col = 0; col < n; col++) {
            if (checkValidPlacement(row, col, column_placements, n)) {
                column_placements[row] = col;
                totalNQueens(row + 1, column_placements, n);
            }
        }
    }

    public static int totalNQueens(int n) {
        int[] column_placements = new int[n];
        placements = 0;
        totalNQueens(0, column_placements, n);
        return placements;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
