package LinkedList;

/**
 * Created by manshu on 1/8/15.
 */
public class ParitionList {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode temp = head;
        ListNode prev = null;
        ListNode mid = null;
        ListNode midPrev = null;
        ListNode midNext = null;
        while (temp != null) {
            if (temp.val == x) break;
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return head; // x not found in the list
        mid = temp;
        midPrev = prev;

        temp = head;
        prev = null;
        int zone = 0;
        while (temp != null) {
            if (temp == mid){
                zone = 1 - zone;
                midPrev = prev;
            }
            else
                if (zone == 0) {
                    if (temp.val > x) {
                        ListNode ahead1 = temp.next;
                        if (midNext == null) {
                            temp.next = mid.next;
                            mid.next = temp;
                            midNext = temp;
                        } else {
                            temp.next = midNext.next;
                            midNext.next = temp;
                            midNext = temp;
                        }
                        if (prev == null) head = ahead1;
                        else prev.next = ahead1;
                        temp = ahead1;
                        continue;
                    }
                }
                else {
                    if (temp.val < x) {
                        prev.next = temp.next;
                        temp.next = mid;
                        if (midPrev == null) head = temp;
                        else midPrev.next = temp;
                        midPrev = temp;
                        temp = prev.next;
                        continue;
                    }
                }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static int listLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println(head);
        System.out.println(partition(head, 3));
    }
}
