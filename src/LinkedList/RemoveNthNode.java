package LinkedList;

/**
 * Created by manshu on 1/7/15.
 */
public class RemoveNthNode {
    private static int lengthList(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int length = lengthList(head);
        if (n > length) return head;

        int counter = length - n + 1;
        ListNode temp = head, prev = null;

        while (temp != null) {
            counter--;
            if (counter == 0) {
                if (prev == null)
                    head = temp.next;
                else
                    prev.next = temp.next;
                temp.next = null;
                temp = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(removeNthFromEnd(head, 6));
    }
}
