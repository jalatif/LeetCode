import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by manshu on 9/2/14.
 */
public class TrieST<Value> {
    private final static int R = 256;
    private Node root = new Node();

    private static class Node{
        private Object value;
        private Node next[] = new Node[R];
    }

    public void put(String key, Value val){
        if (key.equals(" ") || key.equals(""))
            return;
        Node x = root;
        for (int d = 0; d < key.length(); d++){
            char c = key.charAt(d);
            if (x.next[c] == null)
                x.next[c] = new Node();
            x = x.next[c];
        }
        x.value = val;
    }

    public Value get(String key){
        Node x = root;
        for (int d = 0; d < key.length(); d++){
            char c = key.charAt(d);
            if (x.next[c] == null)
                return null;
            x = x.next[c];
        }
        return (Value) x.value;
    }

    public static void main(String args[]){

        FileReader fr;
        BufferedReader br;
        TrieST<String> ts = new TrieST<String>();
        try {
            fr = new FileReader("/home/manshu/.aliases");
            br = new BufferedReader(fr);
            String line = "";
            String st[];
            int line_num = 0;
            while ((line = br.readLine()) != null){
                line_num++;
                st = line.split("\\s|[=]|\"|[-]");
                int i = 0;
                for (String word : st){
                    i++;
                    ts.put(word, "line:" + line_num + ", word: " + i);
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ts.put("she", "0");
        ts.put("sells", "1");
        ts.put("sea", "2");
        ts.put("shells", "3");
        ts.put("by", "4");
        ts.put("the", "5");
        ts.put("sea", "6");
        ts.put("shore", "7");

        System.out.println(ts.get("kupdate"));


    }
}
