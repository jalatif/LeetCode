package LinkedList;

/**
 * Created by manshu on 12/27/14.
 */
public class SList2BST {
    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val == root.val)        return root;
        else if (val < root.val)    root.left = insertNode(root.left, val);
        else                        root.right = insertNode(root.right, val);
        return root;
    }

    private int listLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        return len;
    }

    private ListNode getNode(ListNode head, int index) {
        ListNode temp = head;
        int current = 0;
        while (current != index && temp != null) {
            current += 1;
            temp = temp.next;
        }
        return temp;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int len = listLength(head);

        ListNode mid = getNode(head, len / 2);
        if (mid == null) return null;

        TreeNode root = new TreeNode(mid.val);
        ListNode temp = head;
        while (temp != null) {
            insertNode(root, temp.val);
            temp = temp.next;
        }
        System.out.println(mid);
        return root;
    }

    public static void main (String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        SList2BST slb = new SList2BST();
        TreeNode root = slb.sortedListToBST(head);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}




