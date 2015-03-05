package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manshu on 3/5/15.
 */
public class SurroundedRegions {
    private static class Point {
        int x;
        int y;
        Point(int x, int y) {this.x = x; this.y = y;}
    }
    private static void runBFS(Point start, char[][] board, boolean[][] visited) {
        if (board[start.x][start.y] != 'O') return;
        Queue<Point> queue = new LinkedList<Point>();
        LinkedList<Point> path = new LinkedList<Point>();
        queue.add(start);
        boolean reachingEnd = false;
        Point current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (visited[current.x][current.y]) continue;
            if (((current.x + 1) == board.length) || ((current.y + 1) == board[0].length) ||
                    (current.x == 0) || (current.y == 0)){
                reachingEnd = true;
            }
            visited[current.x][current.y] = true;
            path.add(current);
            if (((current.x + 1) < board.length) && (board[current.x + 1][current.y] == 'O') && !visited[current.x + 1][current.y])
                queue.add(new Point(current.x + 1, current.y));
            if (((current.y + 1) < board[0].length) && (board[current.x][current.y + 1] == 'O') && !visited[current.x][current.y + 1])
                queue.add(new Point(current.x, current.y + 1));
            if (((current.x - 1) >= 0) && (board[current.x - 1][current.y] == 'O') && !visited[current.x - 1][current.y])
                queue.add(new Point(current.x - 1, current.y));
            if (((current.y - 1) >= 0) && (board[current.x][current.y - 1] == 'O') && !visited[current.x][current.y - 1])
                queue.add(new Point(current.x, current.y - 1));
        }
        if (!reachingEnd) {
            for (Point p : path)
                board[p.x][p.y] = 'X';
        }
    }

    public static void solve(char[][] board) {
        if (board == null) return;
        if (board.length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') continue;
                if (visited[i][j]) continue;
                runBFS(new Point(i, j), board, visited);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board2 = {
            {'x', 'x', 'x', 'x'},
            {'x', 'o', 'o', 'x'},
            {'x', 'x', 'o', 'x'},
            {'x', 'o', 'o', 'x'}
        };

        char[][] board3 = {
                {'x', 'x', 'x'},
                {'x', 'o', 'x'},
                {'x', 'x', 'x'},
        };

        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'},
        };

        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
