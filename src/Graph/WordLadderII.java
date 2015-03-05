package Graph;

import java.util.*;

/**
 * Created by manshu on 2/14/15.
 */
public class WordLadderII {
    private static class QueueItem {
        String data;
        int distance;
        QueueItem parent;
        QueueItem(String s, int d, QueueItem p) {data = s; distance = d; parent = p;}
    }

    private static boolean isClose(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int match = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) match++;
        }

        return (match == s1.length() - 1);
    }

    private static List<String> formList(QueueItem queueItem) {
        LinkedList<String> result = new LinkedList<String>();
        while (queueItem != null) {
            result.addFirst(queueItem.data);
            queueItem = queueItem.parent;
        }    
        return result;
    }
    
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {

        List<List<String>> ladders = new ArrayList<List<String>>();
        
        Queue<QueueItem> queue = new LinkedList<QueueItem>();
        queue.add(new QueueItem(start, 1, null));

        QueueItem current;
        int leastDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.println(current.data);
            if (current.distance > leastDist) break;
            if (current.data.equals(end)) {
                ladders.add(formList(current));
                leastDist = current.distance;
                continue;
            }
                
            Iterator<String> iterator = dict.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (isClose(current.data, s) && !queue.contains(s)) {
                    queue.add(new QueueItem(s, current.distance + 1, current));
                    //iterator.remove();
                }
            }
        }

        return ladders;
    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "dog";
        String words[] = {"hot", "dog"};
        String words2[] = {"hot","dot","dog","lot","log", "cog"};
        Set<String> dict = new HashSet<String>(Arrays.asList(words));
        //for (String s : dict) System.out.println(s);

        System.out.println(findLadders(start, end, dict));
    }
}
