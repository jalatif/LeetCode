package LinkedList;

/**
 * Created by manshu on 12/25/14.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        if (this == null) return "NULL";
        String list_str = "";
        ListNode temp = this;
        list_str = String.valueOf(this.val);
        while (true){
            temp = temp.next;
            if (temp == null) {
                list_str += " -> " + "NULL";
                break;
            }
            list_str += " -> " + String.valueOf(temp.val);
        }
        return list_str;
    }
}