package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manshu on 3/3/15.
 */
public class ScrambledString {
    private static class Tuple<T extends Comparable> {
        T item1;
        T item2;
        Tuple(T i1, T i2) {item1 = i1; item2 = i2;}

        @Override
        public int hashCode() {
            return item1.hashCode() * 31 + item2.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Tuple<T> t = (Tuple<T>) obj;
            return item1.equals(t.item1) && item2.equals(t.item2);
        }
    }
    
    private static Map<Tuple<String>, Boolean> cache;
    
    public static boolean isScrambleHelper(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (cache.containsKey(new Tuple<String>(s1, s2))) return cache.get(new Tuple<String>(s1, s2));
        if (s1.equals(s2)) {
            cache.put(new Tuple<String>(s1, s2), true);
            return true;
        }
        
        for (int i = 0; i < s1.length() - 1; i++) {
            String ts1 = s1.substring(0, i + 1);
            String ts11 = s1.substring(i + 1);

            String ts2  = s2.substring(0, i + 1);
            String ts22 = s2.substring(i + 1);

            String ts23  = s2.substring(0, s2.length() - i - 1);
            String ts24 = s2.substring(s2.length() - i - 1);
            
            if ((isScrambleHelper(ts1, ts2) && isScrambleHelper(ts11, ts22)) || (isScrambleHelper(ts1, ts24) && isScrambleHelper(ts11, ts23))) { 
                cache.put(new Tuple<String>(s1, s2), true);
                return true;
            }
        }
        cache.put(new Tuple<String>(s1, s2), false);
        return false;
    }
    public static boolean isScramble(String s1, String s2) {
        cache = new HashMap<Tuple<String>, Boolean>();
        return isScrambleHelper(s1, s2);
    }
    
    public static void main(String[] args) {
        System.out.println(isScramble("great", "tgaer"));
    }
}
