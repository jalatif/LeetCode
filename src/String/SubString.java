package String;

/**
 * Created by manshu on 3/4/15.
 */
public class SubString {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            i -= j;
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abcdaceq";
        String p = "as";
        System.out.println(strStr(s, p));
    }
}
