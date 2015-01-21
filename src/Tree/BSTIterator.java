package Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by manshu on 1/2/15.
 */
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode last = stack.pop();
        int result = last.val;
        last = last.right;
        while (last != null) {
            stack.push(last);
            last = last.left;
        }
        return result;
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

        BSTIterator i = new BSTIterator(root);
        List<Integer> v = new ArrayList<Integer>();
        while (i.hasNext())
            v.add(i.next());
        Iterator<Integer> i2 = v.iterator();
        while (i2.hasNext()) System.out.print(i2.next() + " ");
    }

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */