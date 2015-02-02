package DynamicProgramming;

/**
 * Created by manshu on 1/27/15.
 */
public class EditDistance {
    
    private static int cache[][];
    
    private static int cr = 1, cd = 1, ci = 1;
    
    private static int minDistance(String word1, String word2, int i, int j) {
        if (i == -1) return ci * (j + 1);
        if (j == -1) return cd * (i + 1);
        
        if (cache[i][j] != 0) return cache[i][j];
        
        int cost = 0;
        
        if (word1.charAt(i) == word2.charAt(j)) {
            cost = minDistance(word1, word2, i - 1, j - 1);
        } else {
            int cost1 = cd + minDistance(word1, word2, i - 1, j);
            int cost2 = ci + minDistance(word1, word2, i, j - 1);
            int cost3 = cr + minDistance(word1, word2, i - 1, j - 1);
            cost = Math.min(Math.min(cost1, cost2), cost3);
        }
        cache[i][j] = cost;
        return cost;
    }
    
    public static int minDistance(String word1, String word2) {
        cache = new int[word1.length()][word2.length()];
        return minDistance(word1, word2, word1.length() - 1, word2.length() -1);
    }
    
    public static void main(String[] args) {
        System.out.println(minDistance("sunday", "saturday"));
    }
}
