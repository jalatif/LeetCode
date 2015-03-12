package Backtracking;

import java.util.*;

/**
 * Created by manshu on 3/10/15.
 */
public class SolveSudoku {

    public static boolean solveSudokuUtil(char[][] board, int[][][] ordering, List<Integer> unassigned_vars, int index) {
        if (unassigned_vars.size() <= index) return true;

        Integer var = unassigned_vars.get(index);
        int row = var / board.length;
        int col = var % board.length;
        for (int i = 0; i < board.length; i++) {
            board[row][col] = (char) (48 + i + 1);
            int sub_block = (row / 3) * 3 + col / 3;
            if (ordering[0][row][i] != 0 || ordering[1][col][i] != 0 || ordering[2][sub_block][i] != 0) continue;

            ordering[0][row][i] += 1;
            ordering[1][col][i] += 1;
            ordering[2][sub_block][i] += 1;

            boolean result = solveSudokuUtil(board, ordering, unassigned_vars, index + 1);
            if (result) return true;
            else {
                board[row][col] = '.';
                ordering[0][row][i] -= 1;
                ordering[1][col][i] -= 1;
                ordering[2][sub_block][i] -= 1;
            }
        }
        return false;
    }

    public static void solveSudoku(char[][] board) {
        int[][][] ordering = new int[3][board.length][board.length];
        List<Integer> unassigned_vars = new ArrayList<Integer>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') unassigned_vars.add(i * board.length + j);
                else {
                    int x = board[i][j] - 48 - 1;
                    int sub_block = (i / 3) * 3 + j / 3;

                    ordering[0][i][x] += 1;
                    ordering[1][j][x] += 1;
                    ordering[2][sub_block][x] += 1;

                    if (ordering[0][i][x] > 1) return;
                    if (ordering[1][j][x] > 1) return;
                    if (ordering[2][sub_block][x] > 1) return;
                }
            }
        }
        solveSudokuUtil(board, ordering, unassigned_vars, 0);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
