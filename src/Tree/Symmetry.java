package Tree;

/**
 * Created by manshu on 12/30/14.
 */

public class Symmetry {

    private boolean isSymmetric(TreeNode tn1, TreeNode tn2) {
        if (tn1 == null && tn2 == null) return true;
        if (tn1 == null || tn2 == null) return false;
        if (tn1.val != tn2.val) return false;

        return isSymmetric(tn1.left, tn2.right) && isSymmetric(tn2.left, tn1.right);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
//
//        root.left.left.left = new TreeNode(2);
//        root.left.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(8);
//        root.left.right.right = new TreeNode(9);
//        root.right.left.left = new TreeNode(9);
//        root.right.left.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(2);

        Symmetry s = new Symmetry();

        System.out.println(s.isSymmetric(root));
        System.out.println(Math.pow(2, 3) - 3);
    }

}
