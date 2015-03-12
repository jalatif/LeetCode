package Hashing;

/**
 * Created by manshu on 3/10/15.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int[][][] ordering = new int[3][9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int x = board[i][j] - 48 - 1;
                int sub_block = (i / 3) * 3 + j / 3;

                ordering[0][i][x] += 1;
                ordering[1][j][x] += 1;
                ordering[2][sub_block][x] += 1;
                if (ordering[0][i][x] > 1) return false;
                if (ordering[1][j][x] > 1) return false;
                if (ordering[2][sub_block][x] > 1) return false;
            }
        }

        return true;
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

        System.out.println(isValidSudoku(board));
    }
}
