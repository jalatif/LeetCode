package String;

/**
 * Created by manshu on 2/13/15.
 */
public class LongestPailindromicString {
    
    
    public static int longestPalindrome(String s) {
        int n = s.length();
        int cache[][] = new int[n][n];

        int max = 1;
        
        for (int i = 0; i < n; i++){
            cache[i][i] = 1;
            if (i != (n - 1) && s.charAt(i) == s.charAt(i + 1)) {
                cache[i][i + 1] = 1;
                max = 2;
            }
        }
        
        for (int len = 3; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    cache[i][j] = 1;//cache[i+1][j-1] + 2;
                    max = len;
                } else {
                    cache[i][j] = 0;//Math.max(cache[i + 1][j], cache[i][j - 1]);
                }
            }   
            
        } 
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    cache[i][j] = cache[i + 1][j - 1] + 2;
//                    if (cache[i][j] > max) max = cache[i][j];
//                }
//
//            }
//        }
        return max;
    }

    public static void main(String[] args) {
        String s = "forgeekskeegfor";
        System.out.println(longestPalindrome(s));
    }
}
