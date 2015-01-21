package LinkedList;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manshu on 1/16/15.
 */
class RandomListNode implements Serializable{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        RandomListNode temp = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            RandomListNode trandom = temp.random;
            String tLabel;
            if (trandom == null) tLabel = "null";
            else tLabel = String.valueOf(trandom.label);
            stringBuilder.append("(" + temp.label + "[-]" + tLabel + ")" + "--->");
            temp = temp.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}

public class CopyListWithRandomPointer {

     public static RandomListNode CopyRandomList(RandomListNode head) {
         if (head == null) return null;

         RandomListNode newHead = null;
         RandomListNode newTemp = null, temp = head;
         RandomListNode prev = null;

         Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

         boolean doingRandom = false;
         while (temp != null) {
             if (newTemp == null && !doingRandom){
                 newTemp = new RandomListNode(temp.label);
                 newHead = newTemp;
             } else {
                 if (doingRandom) {
                     newTemp.random = map.get(temp.next);//new RandomListNode(temp.label);
                     newTemp = newTemp.next;
                 } else {
                    newTemp.next = new RandomListNode(temp.label);
                    newTemp = newTemp.next;
                 }
             }
             if (!doingRandom) map.put(temp, newTemp);
             prev = temp;
             if (!doingRandom) {
                 temp = temp.next;
                 prev.next = prev.random;
                 prev.random = temp;
             }
             else {
                 temp = temp.random;
                 prev.random = prev.next;
                 prev.next = temp;
             }
             if (temp == null && !doingRandom) {
                 //System.out.println(head);
                 doingRandom = true;
                 temp = head;
                 prev = null;
                 newTemp = newHead;
             }
         }
         //System.out.println(head);
         return newHead;
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode newHead = null;
        RandomListNode newTemp = null, temp = head;
        RandomListNode prev = null;

        while (temp != null) {
            if (newTemp == null) {
                newTemp = new RandomListNode(temp.label);
                newHead = newTemp;
            } else {
                newTemp.next = new RandomListNode(temp.label);
                newTemp = newTemp.next;
            }
            prev = temp;
            temp = temp.next;
            prev.next = newTemp;
            newTemp.random = prev;
        }
        newTemp = newHead;
        prev = null;
        while (newTemp != null) {
            temp = newTemp.random;
            if (temp.random == null) newTemp.random = null;
            else newTemp.random = temp.random.next;

            //if (newTemp.next != null) temp.next = newTemp.next.random;
            newTemp = newTemp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(5);
        RandomListNode r1 = new RandomListNode(4);
        RandomListNode r2 = new RandomListNode(3);
        RandomListNode r3 = new RandomListNode(2);
        RandomListNode r4 = new RandomListNode(1);
        RandomListNode r5 = new RandomListNode(0);

        head.next = r1; r1.next = r2; r2.next = r3; r3.next = r4; r4.next = r5;
        head.random = r3; r1.random = head; r2.random = r2; r3.random = null; r4.random = r2; r5.random = r1;

        System.out.println(r1);
        InputStream is = new ByteArrayInputStream(r1.toString().getBytes());
        ObjectInputStream ois;

        try {
            ois = new ObjectInputStream(is);
            System.out.println((RandomListNode) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(head);
        RandomListNode nHead = copyRandomList(head);
        System.out.println(nHead);
//        head.next = r2;
//        head.random = head;
//        System.out.println(head);
//        System.out.println(nHead);

    }
}
