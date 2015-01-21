package LinkedList;

/**
 * Created by manshu on 1/8/15.
 */
public class SortedList2BST {
    ListNode listNode;

    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(-1);
        root.left = sortedListToBST(lo, mid - 1);
        root.val = listNode.val;
        listNode = listNode.next;
        root.right = sortedListToBST(mid + 1, hi);

        return root;
    }

    private int listLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public TreeNode sortedListToBST(ListNode head) {
        listNode = head;
        return sortedListToBST(0, listLength(head) - 1);
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);

        System.out.println(head);
        SortedList2BST sortedList2BST = new SortedList2BST();
        System.out.println(sortedList2BST.sortedListToBST(head));
    }
}
