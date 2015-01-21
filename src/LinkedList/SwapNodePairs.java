package LinkedList;

/**
 * Created by manshu on 12/25/14.
 */
public class SwapNodePairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head, temp2;
        head = head.next;
        temp2 = head.next;
        head.next = temp;
        temp.next = swapPairs(temp2);
        return head;
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(swapPairs(head));
    }
}
