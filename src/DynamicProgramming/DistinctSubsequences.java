package DynamicProgramming;

/**
 * Created by manshu on 1/27/15.
 */
public class DistinctSubsequences {
    
    private static int cache[][];
    
    public static int numDistinct(String S, String T, int i, int j) {
        if (i == 0) return 0;
        if (j == 0) return 1;
        
        //System.out.println(S.charAt(i) + "?==?" + T.charAt(j) + " at " + i + "," + j);
        if (cache[i][j] != 0) {
            //System.out.println("\tFound in cache." + cache[i][j]);
            return 1;//cache[i][j];
        }
        
        int max = 0;
        if (S.charAt(i) == T.charAt(j)) {
            int nd1 = numDistinct(S, T, i - 1, j);
            int nd2 = numDistinct(S, T, i - 1, j - 1);
            max = nd1 + nd2;
        } else {
            max = numDistinct(S, T, i, j - 1);
        }
        cache[i][j] = max;
        //System.out.println("\t\t" + S.charAt(i) + "?==?" + T.charAt(j) + " at " + i + "," + j);
        return max;
    }
    
    public static int numDistinct(String S, String T) {
        cache = new int[S.length()][T.length()];
        return numDistinct(S, T, S.length() - 1, T.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbbit", "rabbit"));
    }
}
