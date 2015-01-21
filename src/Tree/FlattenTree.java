package Tree;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by manshu on 12/30/14.
 */
public class FlattenTree {
    public static void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode temp;
        while(!stack.empty()) {
            temp = stack.pop();
            while (temp != null) {
                if (temp.right != null) stack.push(temp.right);
                temp.right = temp.left;
                temp.left = null;
                if (temp.right == null) {
                    if (!stack.empty()) temp.right = stack.peek();
                    break;
                }
                temp = temp.right;
            }
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(root);
        flatten(root);
        System.out.println(root);

    }
}
