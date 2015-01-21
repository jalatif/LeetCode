package LinkedList;

/**
 * Created by manshu on 1/10/15.
 */
public class SortList {

    private static int lengthList(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

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

    private static ListNode list;
    private static ListNode sortList(int lo, int hi) {
        if (lo >= hi) {
            ListNode temp = list;
            list = list.next;
            temp.next = null;
            return temp;
        }
        int mid = lo + (hi - lo) / 2;
        ListNode temp1 = sortList(lo, mid);
        ListNode temp2 = sortList(mid + 1, hi);
        return mergeTwoLists(temp1, temp2);
    }

    public static ListNode sortList(ListNode head) {
        int length = lengthList(head);
        if (length == 0 || length == 1) return head;
        list = head;
        head = sortList(0, length - 1);
        return head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(7);

        System.out.println(head);
        System.out.println(sortList(head));
    }
}
