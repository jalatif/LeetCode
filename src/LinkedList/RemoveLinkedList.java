package LinkedList;

/**
 * Created by manshu on 4/23/15.
 */
public class RemoveLinkedList {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode temp = head, prev = null;
        while (temp != null) {
            if (temp.val == val) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println(removeElements(head, 6));
    }
}
