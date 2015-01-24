package String;

/**
 * Created by manshu on 1/21/15.
 */
public class CountAndSay {
    private static String getName(int x) {
        String name = "zero";
        switch (x) {
            case 0: {name = "zero"; break;}
            case 1: {name = "one"; break;}
            case 2: {name = "two"; break;}
            case 3: {name = "three"; break;}
            case 4: {name = "four"; break;}
            case 5: {name = "five"; break;}
            case 6: {name = "six"; break;}
            case 7: {name = "seven"; break;}
            case 8: {name = "eight"; break;}
            case 9: {name = "nine"; break;}

        }
        return name;
    }
    
    public static String sayNumber(int n) {
        String s = String.valueOf(n);
        StringBuilder result = new StringBuilder();
        char prev = '\n';
        int count = 0;
        char current_char;
        for (int i = 0; i < s.length(); i++) {
            current_char = s.charAt(i);
            if (current_char == prev) count++;
            else {
                if (prev != '\n') {
                    result.append(getName(count)).append(" ");
                    result.append(prev);
                    if (count > 1) result.append("s");
                    result.append(" ");
                }
                count = 1;
                prev = current_char;
            }
            
        }
        if (prev != '\n') {
            result.append(getName(count)).append(" ");
            result.append(prev);
            if (count > 1) result.append("s");
        }
        return result.toString();
    }

    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        String previous = "1";
        char current_char;
        while (n-- > 1) {
            char prev = '\n';
            int count = 0;
            System.out.println(previous);
            for (int i = 0; i < previous.length(); i++) {
                current_char = previous.charAt(i);
                if (current_char == prev) count++;
                else {
                    if (prev != '\n') {
                        result.append(String.valueOf(count)).append(Integer.parseInt(String.valueOf(prev)));
                    }
                    count = 1;
                    prev = current_char;
                }
            }
            if (prev != '\n') {
                result.append(String.valueOf(count)).append(Integer.parseInt(String.valueOf(prev)));
            }
            previous = result.toString();
            result = new StringBuilder();
        }
        return String.valueOf(previous);
    }
        public static void main(String[] args) {
        System.out.println(sayNumber(1211));
        System.out.println(countAndSay(5));
    }
}
