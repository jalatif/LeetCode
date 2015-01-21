package LinkedList;

/**
 * Created by manshu on 1/7/15.
 */
public class Add2Numbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        int carry = 0, n1, n2, result;
        ListNode head = null, tail = null;
        while (c1 != null || c2 != null) {
            if (c1 == null) n1 = 0;
            else n1 = c1.val;
            if (c2 == null) n2 = 0;
            else n2 = c2.val;

            result = n1 + n2 + carry;
            carry = result / 10;
            result = result % 10;

            if (tail == null) head = tail = new ListNode(result);
            else {
                tail.next = new ListNode(result);
                tail = tail.next;
            }
            if (c1 != null) c1 = c1.next;
            if (c2 != null) c2 = c2.next;

        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
            tail = tail.next;
        }
        return head;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(9);
        System.out.println(head1);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);
        System.out.println(head2);

        System.out.println(addTwoNumbers(head1, head2));

    }
}
