package General;

import Tree.TreeNode;

/**
 * Created by manshu on 2/5/15.
 */
public class DeleteNodeInBST {
    
    public static TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) return root;
        
        if (root.val != val) {
            root.left = deleteNode(root.left, val);
            root.right = deleteNode(root.right, val);
        }  else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode temp = root.left;
                TreeNode prev = root;
                while (temp.right != null) {
                    prev = temp;
                    temp = temp.right;
                }        
                if (prev == root) {
                    temp.right = root.right;
                    root = temp;
                } else {
                    prev.right = temp.left;
                    temp.right = root.right;
                    temp.left = root.left;
                    root = temp;
                } 
                
            }
        }
        return root;
    }

    public static void main(String[] args) {
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

        System.out.println(deleteNode(root, 10));
    }
}
