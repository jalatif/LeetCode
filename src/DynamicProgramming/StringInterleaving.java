package DynamicProgramming;

/**
 * Created by manshu on 3/3/15.
 */
public class StringInterleaving {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        
        int n1 = s1.length();
        int n2 = s2.length();
        int m  = s3.length();
        
        if (m != (n1 + n2)) return false;
        
        boolean cache[][] = new boolean[n1 + 1][n2 + 1];
        cache[0][0] = true;
        
        for (int i = 0; i <= n1; i++)
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) continue;
                if (i != 0 && j != 0)
                    cache[i][j] = (cache[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1))) ||
                                  (cache[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1)));
                else if (i == 0)
                    cache[i][j] = cache[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1));
                else
                    cache[i][j] = cache[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1));
            }
        
        

        return cache[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        
        String s3 = "aadbbcbcac";
        s3 = "aadbbbaccc";
        
        System.out.println(isInterleave(s1, s2, s3));
    }
}
