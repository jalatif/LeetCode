package Backtracking;

/**
 * Created by manshu on 3/3/15.
 */
public class WordSearch {

    private static boolean picked[][];
    private static boolean exist(char[][] board, String word, int i, int j) {
        if (word.length() == 0) return true;
        
        if ((i + 1) < board.length && !picked[i + 1][j]) {
            if (word.charAt(0) == board[i + 1][j]) {
                picked[i + 1][j] = true;
                if (exist(board, word.substring(1), i + 1, j))
                    return true;
                picked[i + 1][j] = false;
            }
        }
        if ((i - 1) >= 0 && !picked[i - 1][j]) {
            if (word.charAt(0) == board[i - 1][j]) {
                picked[i - 1][j] = true;
                if (exist(board, word.substring(1), i - 1, j))
                    return true;
                picked[i - 1][j] = false;
            }
        }
        if ((j + 1) < board[i].length && !picked[i][j + 1]) {
            if (word.charAt(0) == board[i][j + 1]) {
                picked[i][j + 1] = true;
                if (exist(board, word.substring(1), i, j + 1))
                    return true;
                picked[i][j + 1] = false;
            }
        }
        if ((j - 1) >= 0 && !picked[i][j - 1]) {
            if (word.charAt(0) == board[i][j - 1]) {
                picked[i][j - 1] = true;
                if (exist(board, word.substring(1), i, j - 1))
                    return true;
                picked[i][j - 1] = false;
            }
        }
        
        return false;
    }
    
    public static boolean exist(char[][] board, String word) {
        if (word == null) return false;
        if (word.length() == 0) return true;
        
        picked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    picked[i][j] = true;
                    if (exist(board, word.substring(1), i, j))
                        return true;
                    picked[i][j] = false;
                }
                
            }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
        };
        String word = "SEECS";

        System.out.println(exist(board, word));
    }
}
