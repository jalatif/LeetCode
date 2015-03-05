package String;

import java.util.*;

/**
 * Created by manshu on 3/4/15.
 */
public class Anagrams {
    
    public static List<String> anagrams(String[] strs) {
        List<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            //System.out.println(temp);
            if (map.containsKey(temp)) {
                if (map.get(temp) != -1) {
                    list.add(strs[map.get(temp)]);
                    map.put(temp, -1);
                }
                list.add(strs[i]);
            }
            else
                map.put(temp, i);
        }
        
        return list;
    }

    public static void main(String[] args) {
        String[] strs2 = {"abcd", "dcba", "rabcrd", "dabc", "absd", "abcdw"};
        String[] strs = {"tea","and","ate","eat","dan"};
        List<String> stringList = anagrams(strs);
        for (String s : stringList)
            System.out.println(s);
    }
}
