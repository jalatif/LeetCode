package DynamicProgramming;

/**
 * Created by manshu on 3/3/15.
 */
public class RegularExpression {
   
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        final char asterisk = '*';
        final char dot = '.';
        
        int n = s.length();
        int m = p.length();
        
        boolean[][] cache = new boolean[m + 1][n + 1];
        
        cache[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            char matchChar = p.charAt(i - 1);
            if (matchChar == asterisk) {
                if (i == 1) return false;
                for (int j = 0; j <= n; j++) {
                    cache[i][j] = cache[i - 2][j];
                }
                matchChar = p.charAt(i -  2);
                for (int j = 1; j <= n; j++) {
                    if ((cache[i - 2][j - 1] || cache[i][j - 1]) && ((matchChar == s.charAt(j - 1)) || matchChar == dot))
                        cache[i][j] = true;
                }
            } else {
                for (int j = 1; j <= n; j++) {
                    if (cache[i - 1][j - 1] && ((matchChar == s.charAt(j - 1)) || matchChar == dot))
                        cache[i][j] = true;
                    
                }
            }
            
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (cache[i][j])
                    System.out.print("T ");
                else
                    System.out.print("F ");
            }
            System.out.println();
        }
        return cache[m][n];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "a.*";
        System.out.println(isMatch(s, p));
    }
}
