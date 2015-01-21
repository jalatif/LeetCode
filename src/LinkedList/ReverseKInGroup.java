package LinkedList;

/**
 * Created by manshu on 1/7/15.
 */
public class ReverseKInGroup {

    private static int lengthList(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev = null;
        ListNode temp2 = null;
        ListNode temp3 = null;

        while (temp != null) {
            temp2 = temp.next;
            if (temp2 == null) {
                temp.next = prev;
                head = temp;
                return head;
            }
            temp.next = prev;
            temp3 = temp2.next;
            temp2.next = temp;
            prev = temp2;
            temp = temp3;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || lengthList(head) < k) return head;
        ListNode temp = head;
        ListNode prev = null;
        ListNode temp2;
        ListNode temp3;
        int counter = k;
        while (temp != null && counter > 1) {
            temp2 = temp.next;
            if (temp2 == null) {
                temp.next = prev;
                temp2 = temp;
                prev = temp;
                break;
            }
            temp.next = prev;
            temp3 = temp2.next;
            temp2.next = temp;
            prev = temp2;
            temp = temp3;
            counter -= 2;
        }
//        System.out.println(counter);
        if (counter == 1) {
            temp2 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
//        System.out.println(temp);
//        System.out.println(head);
//        System.out.println(prev);

        head.next = reverseKGroup(temp, k);
        return prev;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        //head = reverse(head);
        //System.out.println(head);
        //System.out.println(lengthList(head));
        System.out.println(reverseKGroup(head, 3));
    }
}
