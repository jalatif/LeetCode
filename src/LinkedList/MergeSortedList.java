package LinkedList;

/**
 * Created by manshu on 1/7/15.
 */
public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        ListNode prev = null;
        ListNode head = l1;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                if (prev == null) head = c1;
                else prev.next = c1;
                prev = c1;
                c1 = c1.next;
            } else {
                if (prev == null) head = c2;
                else prev.next = c2;
                prev = c2;
                c2 = c2.next;
            }
        }

        if (c1 == null) {
            while (c2 != null) {
                if (prev == null) head = c2;
                else prev.next = c2;
                prev = c2;
                c2 = c2.next;
            }
        }
        if (c2 == null) {
            while (c1 != null) {
                if (prev == null) head = c1;
                else prev.next = c1;
                prev = c1;
                c1 = c1.next;
            }
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

        ListNode head2 = null;// new ListNode(2);
//        head2.next = new ListNode(4);
//        head2.next.next = new ListNode(6);
//        head2.next.next.next = new ListNode(8);
//        head2.next.next.next.next = new ListNode(10);
        System.out.println(head2);

        System.out.println(mergeTwoLists(head1, head2));

    }
}
