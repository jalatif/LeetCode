package Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manshu on 2/20/15.
 */
public class DisjointSet<T> {
    
    private class Item {
        T item;
        Integer index;
        int size;
        Item(T t, int i) {item = t; index = i; size=1;}
    }
    
    private int length;
    private Object[] S;
    Map<T, Integer> index_map; 
    
    public DisjointSet(int size) {
        S = new Object[size];
        index_map = new HashMap<T, Integer>(size);
        length = 0;
    }
    
    //create set and return name
    public int makeSet(T x) {
        if (length == S.length) {
            System.out.println("Cannot create more set");
            return -1;//invalid creation
        }
        S[length] = new Item(x, length);
        index_map.put(x, length);
        length++;
        return length - 1;
    }
    
    private int find(int index) {
        Item item = (Item) S[index];
        if (item.index == index) return index;
        return find(item.index);
    }
    
    public int find(T item) {
        Integer index = index_map.get(item);
        if (index == null) {
            System.out.println("No such item in the disjoint set");
            return -1;//invalid set name
        }
        return find(index);
    }
    
    private void union(int item1, int item2) {
        int root1 = find(item1);
        int root2 = find(item2);
        
        Item ritem1 = (Item) S[root1];
        Item ritem2 = (Item) S[root2];
        if (ritem1.size > ritem2.size) {
            S[root2] = new Item(ritem2.item, ritem1.index);
        } else if (ritem1.size < ritem2.size) {
            S[root2] = new Item(ritem2.item, ritem1.index);
        } else {
            S[root2] = new Item(ritem2.item, ritem1.index);
            ritem1.size++;
        }
    }

    public int union(T item1, T item2) {
        Integer index1 = index_map.get(item1);
        Integer index2 = index_map.get(item2);
        if (index1 == null || index2 == null) {
            System.out.println("No such items in the disjoint set");
            return -1;//invalid set name
        }
        union(index1, index2);
        return 0;
    }

    private int getHeight(T item) {
        int root = find(item);
        if (root == -1) {
            System.out.println("Element not present");
            return -1;
        }
        Item ritem = (Item)S[root];
        return ritem.size;
    }
    public boolean inSameSet(T item1, T item2) {
        return find(item1) == find(item2);
    }

    public static void main(String[] args) {
        String strings[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        int names[] = new int[strings.length];
        DisjointSet<String> disjointSet = new DisjointSet<String>(strings.length);
        int i = 0;
        for (String s : strings)
            names[i++] = disjointSet.makeSet(s);

        for (String s : strings)
            System.out.println(disjointSet.find(s));
        
        String prev = "A";
        for (String s : strings){
            disjointSet.union(s, prev);
            prev = s;
        }
        
        for (String s : strings)
            System.out.println(disjointSet.inSameSet(s, "B"));

        System.out.println(disjointSet.getHeight("A"));



    }
}
