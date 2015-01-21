package Tree;

import java.util.Stack;

/**
 * Created by manshu on 12/31/14.
 */
public class ValidBST {

    private static boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTT(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode temp;
        while(!stack.empty()) {
            temp = stack.pop();
            while(temp != null) {
                if (temp.left != null && temp.val < temp.left.val) return false;
                if (temp.right != null && temp.val >= temp.right.val) return false;
                stack.push(temp);
                if (temp.left == null) {
                    break;
                }
                temp = temp.left;
            }
            if (!stack.empty()) {
                temp = stack.pop();
                temp = temp.right;
                if (!stack.empty() && temp != null) {
                    if (temp.val > stack.peek().val) return false;
                }
                if (temp != null) stack.push(temp);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(60);

        root.left = new TreeNode(20);
        root.right = new TreeNode(80);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(100);

        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(15);
        root.left.right.left = new TreeNode(30);
        root.left.right.right = new TreeNode(50);

        root.left.right.right.left = new TreeNode(45);
        root.left.right.right.right = new TreeNode(55);

        System.out.println(root);
        System.out.println(isValidBST(root));
        System.out.println(Integer.MIN_VALUE + " " + Integer.MAX_VALUE);
    }
}
