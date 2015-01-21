package Tree;

import java.util.ArrayList;


/**
 * Created by manshu on 1/2/15.
 */
public class RecoverTree {
    private void swapValues(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private TreeNode recoverTree(TreeNode root, int min, int max) {
        if (root == null) return null;
        TreeNode self = (root.val >= max || root.val <= min) ? root : null;

        TreeNode left = recoverTree(root.left, min, root.val);
        TreeNode right = recoverTree(root.right, root.val, max);

        if (left != null && right == null)
            self = left;
//        if (self == null)
//                return left;
//            else
//                swapValues(root, left);
        else if (left == null && right != null)
            self = right;
//        if (self == null)
//                return right;
//            else
//                swapValues(root, right);
        else if (left != null && right != null)
            swapValues(left, right);

        //self = (root.val >= max || root.val <= min) ? root : null;
        if (self != null)
            System.out.println(self.val + " ");
        return self;
    }

    public void recoverTree(TreeNode root) {
        TreeNode rem = recoverTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (rem != null) {
            swapValues(root, rem);
        }
    }

    public static void main(String args[]) {
        RecoverTree rt = new RecoverTree();
//        TreeNode root = new TreeNode(3);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(1);
        TreeNode root = new TreeNode(60);

        root.left = new TreeNode(20);
        root.right = new TreeNode(55);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(100);

        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(15);
        root.left.right.left = new TreeNode(30);
        root.left.right.right = new TreeNode(50);

        root.left.right.right.left = new TreeNode(45);
        root.left.right.right.right = new TreeNode(80);

        System.out.println(root);
        rt.recoverTree(root);
        System.out.println(root);

    }
}
