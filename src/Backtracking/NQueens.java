package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 2/1/15.
 */
public class NQueens {
    
    private static List<String[]> placements;
    
    private static String[] makeFinalBoard(int[] column_placements, int n) {
        String[] board = new String[n];
        for (int i = 0; i < n; i++){
            StringBuilder row_string = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (column_placements[i] == j)
                    row_string.append("Q");
                else
                    row_string.append(".");
            }
            board[i] = row_string.toString();
        }
        return board;
    }
    
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
    
    private static void solveNQueens(int row, int[] column_placements, int n) {
        
        if (row == n) {
            System.out.println("Done");
            placements.add(makeFinalBoard(column_placements, n));
        }
        for (int col = 0; col < n; col++) {
            if (checkValidPlacement(row, col, column_placements, n)) {
                column_placements[row] = col;
                solveNQueens(row + 1, column_placements, n);
            }
        }
    }
    
    public static List<String[]> solveNQueens(int n) {
        int[] column_placements = new int[n];
        placements = new ArrayList<String[]>();
        solveNQueens(0, column_placements, n);    
        return placements;
    }

    public static void main(String[] args) {
        List<String[]> ans = solveNQueens(4);
        for (String[] sa : ans) {
            System.out.println();
            for (String s : sa)
                System.out.println(s);
        }
    }
}
