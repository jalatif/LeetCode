package General;

/**
 * Created by manshu on 2/18/15.
 */
import Tree.TreeNode;

public class MorrisTraversal {

    private static TreeNode inOrderPredecessor(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return null;
        
        TreeNode temp = root.left;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public static void morrisTraversal(TreeNode root) {
        if (root == null) return;
        
        TreeNode temp = root, prev = null, pri = null;
        
        while (temp != null) {
            if (temp.left != null) {
                if (prev != null && prev.left != temp) {
                    prev.right = null;
                    System.out.print(temp.val + " ");
                    if (pri != null && pri.val > temp.val) {
                        System.out.print("<<" + pri.val + " " + temp.val + ">>");
                    }
                    pri = temp;
                    prev = null;
                    temp = temp.right;
                } else {
                    TreeNode tr = inOrderPredecessor(temp);
                    if (tr != null) tr.right = temp;
                    prev = temp;
                    temp = temp.left;
                }
            } else {
                
                System.out.print(temp.val + " ");
                if (pri != null && pri.val > temp.val) {
                    System.out.print("<<" + pri.val + " " + temp.val + ">>");
                }
                pri = temp;
                prev = temp;
                temp = temp.right;
            }
        }
        System.out.println();
    }
    
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
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
        morrisTraversal(root);
        inOrder(root);
    }
}
