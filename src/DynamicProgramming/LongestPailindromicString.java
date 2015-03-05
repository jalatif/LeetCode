package DynamicProgramming;

/**
 * Created by manshu on 3/3/15.
 */
public class LongestPailindromicString {
    
    public static String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 0) return s;
        
        int n = s.length();
        boolean[][] cache = new boolean[n][n];
        
        int max_length = 1, max_start = 0, max_end = 0;
        
        for (int i = 0; i < n; i++) {
            cache[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                cache[i][i + 1] = true;
                if (2 > max_length) {
                    max_start = i; max_end = i + 1;
                    max_length = 2;
                }
            }
        }
        
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                int j = i + k - 1;
                if (j >= n) continue;
                if (cache[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    cache[i][j] = true;
                    if (k > max_length) {
                        max_length = k;
                        max_start = i; max_end = j;
                    }
                }
            }
        }
        
        return s.substring(max_start, max_end + 1);
    }
    
    public static void main(String[] args) {
        String s = "jpklabcacbadmmn";
        s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        s = "ccc";
        System.out.println(longestPalindrome(s));
    }
}
