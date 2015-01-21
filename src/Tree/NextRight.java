package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manshu on 12/30/14.
 */
public class NextRight {
    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();

        if (root == null) return;
        queue.add(root);
        queue.add(null);

        TreeLinkNode temp = null;
        //TreeLinkNode prev = null;
        int level = 0;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == null) {
                level++;
                System.out.println("\nLevel = " + level);
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }
            if (!queue.isEmpty()){
                temp.next = queue.element();
            }
            System.out.print(temp.val + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

    }

    public static void main(String args[]) {
        TreeLinkNode root = new TreeLinkNode(7);

        root.left = new TreeLinkNode(4);
        root.right = new TreeLinkNode(12);

        root.left.left = new TreeLinkNode(2);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(10);
        root.right.right = new TreeLinkNode(15);

        connect(root);

        System.out.println(root.right.left.next.val);
    }

}
