package Array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by manshu on 4/10/15.
 */
public class NumberIslands {

    private static void runDFS(char[][] grid, int location) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(location);
        int M = grid.length, N = grid[0].length;
        int current;
        while (!stack.isEmpty()) {
            current = stack.pop();
            int row = current / N;
            int col = current % N;

            if ((row - 1) >= 0 && grid[row - 1][col] == '1') stack.add((row - 1) * N + col);
            if ((row + 1) < M && grid[row + 1][col] == '1') stack.add((row + 1) * N + col);
            if ((col - 1) >= 0 && grid[row][col - 1] == '1') stack.add(row * N + col - 1);
            if ((col + 1) < N && grid[row][col + 1] == '1') stack.add(row * N + col + 1);

            grid[row][col] = '2';
        }
    }

    public static int numIslands(char[][] grid) {
        int num_islands = 0;
        if (grid.length == 0) return num_islands;
        int M = grid.length, N = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    runDFS(grid, i * N + j);
                    num_islands++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '2') {
                    grid[i][j] = '1';
                }
            }
        }

        return num_islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
