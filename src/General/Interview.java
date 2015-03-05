package General;

/**
 * Created by manshu on 2/3/15.
 */
public class Interview {

    public static String reverseString(String s) {
        int n = s.length();
        char a[] = s.toCharArray();
        
        for (int i = 0; i < n / 2; i++) {
            char temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
        
        return a.toString();
    }
    
    
    public static String reverseWords(String s) {
        
        String s1 = new StringBuilder(s).reverse().toString();
        
        StringBuilder stringBuilder = new StringBuilder();
        
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == ' ') {
                stringBuilder.append(new StringBuilder(s1.substring(start, i)).reverse().toString()).append(' ');
                start = i + 1;
            }
        }
        stringBuilder.append(new StringBuilder(s1.substring(start, s1.length())).reverse().toString());
        return stringBuilder.toString();
    }
    
    

    public static void main(String[] args) {
        String s = "Abhinav Interview";
        String s1 = "This is a sentence";
        
        System.out.println(reverseWords(s1));
    }
}
