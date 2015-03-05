package General;

/**
 * Created by manshu on 2/12/15.
 */
import Tree.TreeNode;

public class DiameterTree {

    private static int maxDiameter;
    private static TreeNode lca;
    
    private static int diameterUtil(TreeNode root) {
        if (root == null) return 0;
        
        int left = diameterUtil(root.left);
        int right = diameterUtil(root.right);
        
        if ((left + right + 1) > maxDiameter){
            maxDiameter = left + right + 1;
            lca = root;
        }
        
        return 1 + Math.max(left, right);
    }

    public static int diameter(TreeNode root) {
        maxDiameter = 0;
        lca = null;
        diameterUtil(root);
        System.out.println(lca);
        return maxDiameter;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.left.left.right.left = new TreeNode(10);
        root.left.right.right.left = new TreeNode(11);
        root.left.right.right.right = new TreeNode(12);

        root.left.left.right.left.left = new TreeNode(13);
        root.left.left.right.left.right = new TreeNode(14);
        root.left.right.right.right.right = new TreeNode(15);

        System.out.println(root);

        System.out.println(diameter(root));

    }
}
