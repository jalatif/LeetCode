package LinkedList;

/**
 * Created by manshu on 1/7/15.
 */
public class RotateList {
    private static int lengthList(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        int length = lengthList(head);
        n = n % length;
        if (n == 0) return head;

        ListNode temp = head;
        ListNode prev = null;
        int counter = length - n;
        while(temp != null && counter > 0) {
            counter--;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        ListNode result = temp;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return result;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        System.out.println(rotateRight(head, 10));
    }
}
