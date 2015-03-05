package Graph;

import java.util.*;

/**
 * Created by manshu on 2/14/15.
 */
public class WordLadder {
    
    private static class QueueItem {
        String data;
        int distance;
        QueueItem(String s, int d) {data = s; distance = d;}
    }
    
    private static boolean isClose(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int match = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) match++;
        }
        
        return (match == s1.length() - 1);
    }
    
    public static int ladderLength(String start, String end, Set<String> dict) {
        
        Queue<QueueItem> queue = new LinkedList<QueueItem>();
        queue.add(new QueueItem(start, 1));
        
        QueueItem current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(current.data);
            if (current.data.equals(end))
                return current.distance;
            Iterator<String> iterator = dict.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (isClose(current.data, s) && !queue.contains(s)) {
                    queue.add(new QueueItem(s, current.distance + 1));
                    iterator.remove();
                }
            }    
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String words[] = {"hot","dot","dog","lot","log", "cog"};
        Set<String> dict = new HashSet<String>(Arrays.asList(words));
        //for (String s : dict) System.out.println(s);

        System.out.println(ladderLength(start, end, dict));
    }
}
