import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by manshu on 9/3/14.
 */
public class Ternary_Trie<Value> {

    private Node<Value> root;
    private static class Node<Value>{
        Value val;
        char key;
        Node<Value> less;
        Node<Value> equal;
        Node<Value> greater;
    }

    public void put(String key, Value value){
        if (key.equals(" ") || key.equals(""))
            return;
        Node<Value> x = root;
        Node<Value> prev = null;
        int i = 0;
        int direction = 0;
        char c;
        while (i != key.length()){
            c = key.charAt(i);
            if (x == null){
                x = new Node<Value>();
                x.key = c;
                i++;
                if (prev != null){

                    if (direction == 1)
                        prev.greater = x;
                    else if (direction == -1)
                        prev.less = x;
                    else
                        prev.equal = x;
                }else{
                    root = x;
                }

                prev = x;
                x = x.equal;
                direction = 0;
                continue;
            }
            prev = x;
            if (c > x.key){
                x = x.greater;
                direction = 1;
            }else if (c < x.key){
                x = x.less;
                direction = -1;
            }else{
                x = x.equal;
                direction = 0;
                i++;
            }
        }
        if (prev == null)
            System.out.println("d " + key + " c");
        prev.val = value;
    }

    public Value get(String key){
        Node<Value> x = root;
        Node<Value> prev = null;
        int i = 0;
        char c;
        while (i != key.length()){
            c = key.charAt(i);
            if (x == null){
                return null;
            }
            prev = x;
            if (c > x.key){
                x = x.greater;
            }else if (c < x.key){
                x = x.less;
            }else{
                x = x.equal;
                i++;
            }
        }
        return prev.val;
    }

    public static void main(String args[]){
        FileReader fr;
        BufferedReader br;
        Ternary_Trie<String> ts = new Ternary_Trie<String>();
        try {
            fr = new FileReader("/home/manshu/.aliases");
            br = new BufferedReader(fr);
            String line = "";
            String st[];
            int line_num = 0;
            while ((line = br.readLine()) != null){
                line_num++;
                st = line.split("\\s+|[=]|\"|[-]");
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
