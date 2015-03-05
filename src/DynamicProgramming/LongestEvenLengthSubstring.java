package DynamicProgramming;

/**
 * Created by manshu on 3/3/15.
 */
public class LongestEvenLengthSubstring {
    
    public static int findLength(String s) {
        int n = s.length();
        int diff[][] = new int[n][n];
        
        int max_length = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int i1 = (int) s.charAt(i) - 48;
            int i2 = (int) s.charAt(i + 1) - 48;
            diff[i][i + 1] = i1 - i2;
            if (diff[i][i + 1] == 0) 
                max_length = 2;
        }
        
        for (int k = 3; k < n; k += 2) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                int i1 = (int) s.charAt(i) - 48;
                int i2 = (int) s.charAt(j) - 48;
                diff[i][j] = diff[i + 1][j - 1] + i1 - i2;
                if (diff[i][j] == 0 && k > max_length) max_length = k;
            }
        }
        return max_length + 1;
    }

    public static void main(String[] args) {
        String s = "1538013";
        System.out.println(findLength(s));
    }
}
