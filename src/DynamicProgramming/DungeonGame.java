package DynamicProgramming;

/**
 * Created by manshu on 1/27/15.
 */
public class DungeonGame {
    

    private static int cache[][];
    
    private static int max(int a, int b) {
        if (a < 0) a = 0;
        if (b < 0) b = 0;
        int c = Math.max(a, b);
        return c;
    }

    private static int calculateMinimumHP(int[][] dungeon, int i, int j) {
        int m = dungeon.length, n = dungeon[0].length;
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (i == (m - 1) && j == (n - 1)){cache[i][j] = max(-1 * dungeon[m - 1][n - 1], 0); return cache[i][j];}
        if (cache[i][j] != 0) return cache[i][j];
        
        int p1_cost = calculateMinimumHP(dungeon, i + 1, j);
        int p2_cost = calculateMinimumHP(dungeon, i, j + 1);

        cache[i][j] = max(-1 * dungeon[i][j], Math.min(p1_cost, p2_cost) - dungeon[i][j]);
        return cache[i][j];
    }
    
    public static int calculateMinimumHPx(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        cache = new int[dungeon.length][dungeon[0].length];
        int result = calculateMinimumHP(dungeon, 0, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(result);
        return result;
//        int healthReq = dungeon[0][0];
//        int min = healthReq;
//        int i = 0, j = 0;
//        while (true) {
//            if ((i == (m - 1) && j == (n - 1))) {
//                break;
//            }
//            if ( (i + 1) == m) j = j + 1;
//            else if ((j + 1) == n) i = i + 1;
//            else {
//                if (cache[i + 1][j] > cache[i][j + 1]) {
//                    i = i + 1;
//                } else {
//                    j = j + 1;
//                }
//            }
//            healthReq += dungeon[i][j];
//            if (healthReq < min) min = healthReq;
//        }
//        System.out.println(min);
//        if (min >= 0) return 1;
//        else return -1 * min + 1;
    }



    public static int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length, N = dungeon[0].length;
        int[][] MH = new int[M][N];
        if (dungeon[M - 1][N - 1] < 0) MH[M - 1][N - 1] = 1 + -1 * dungeon[M - 1][N - 1];
        else if (dungeon[M - 1][N - 1] >= 0) MH[M - 1][N - 1] = 1;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == (M - 1) && j == (N - 1)) continue;
                int s;
                if (dungeon[M - 1][N - 1] < 0) s = 1 + -1 * dungeon[M - 1][N - 1];
                else s = 1;

                int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
                if ((i + 1) < M) {
                    int k = Math.max(-1 * dungeon[i][j] + MH[i + 1][j], 1);
                    r1 = Math.max(s, k);
                }
                if ((j + 1) < N) {
                    int k = Math.max(-1 * dungeon[i][j] + MH[i][j + 1], 1);
                    r2 = Math.max(s, k);
                }
                MH[i][j] = Math.min(r1, r2);
            }
        }
//        if (dungeon[0][0] == 0) {
//            if (MH[0][0] > 0)
//                return MH[0][0] + 1;
//            else
//                return MH[0][0];
//        }
//        else if (dungeon[0][0] < 0) return Math.max(MH[0][0] + 1, 1);
//        else return Math.max(MH[0][0], 1);
        return Math.max(MH[0][0], 1);
    }

    public static void main(String[] args) {
        int arr2[][] = {
                {-2, -3, 3},
                {-5, 10, 1},
                {10, 30, -5},
        };
        
        int arr3[][] = {{0, -5}, {-2, -3}};

        System.out.println(calculateMinimumHP(arr2));
    }
}
