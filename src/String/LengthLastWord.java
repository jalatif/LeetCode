package String;

/**
 * Created by manshu on 1/21/15.
 */
public class LengthLastWord {
    public static int lengthOfLastWord(String s) {
        int startWord = -1;
        int endWord = -1;
        int prevLen = 0;
        char prev = '\n';
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                endWord = i - 1;
                if (endWord != -1) prevLen = endWord - startWord + 1;
                while(i < s.length() && s.charAt(i) == ' ') i++;
                startWord = i;
                if (i == s.length() - 1) return 1;
            } else {
                if (startWord == -1) {startWord = i;}
                if (i == s.length() - 1) {
                    endWord = s.length() - 1;
                    prevLen = endWord - startWord + 1;
                }
            }
        }

        return prevLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("b    a   cd          "));
        System.out.println(lengthOfLastWord(" a"));
        System.out.println(lengthOfLastWord(" "));
    }
}
