package General.practice;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manshu on 4/24/15.
 */

public class FloorTree {

    public static TreeNode isFloor(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        else if (node.val > val) return isFloor(node.left, val);
        else {
            TreeNode attempt = isFloor(node.right, val);
            if (attempt == null) return node;
            return attempt;
        }
    }

    public static void main(String[] args) {
        Tree.TreeNode root = new Tree.TreeNode(60);

        root.left = new Tree.TreeNode(20);
        root.right = new Tree.TreeNode(80);

        root.left.left = new Tree.TreeNode(10);
        root.left.right = new Tree.TreeNode(40);
        root.right.left = new Tree.TreeNode(70);
        root.right.right = new Tree.TreeNode(100);

        root.left.left.left = new Tree.TreeNode(0);
        root.left.left.right = new Tree.TreeNode(15);
        root.left.right.left = new Tree.TreeNode(30);
        root.left.right.right = new Tree.TreeNode(50);

        root.left.right.right.left = new Tree.TreeNode(45);
        root.left.right.right.right = new Tree.TreeNode(55);

        root.inOrder();
        System.out.println();
        System.out.println(isFloor(root, 17).val);
    }
}
