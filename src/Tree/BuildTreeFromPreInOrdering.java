package Tree;

/**
 * Created by manshu on 1/15/15.
 */
public class BuildTreeFromPreInOrdering {

    private static TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        //System.out.println(s1 + " " + e1 + ", " + s2 + " " + e2);
        if (s1 > e1) return null;
        if (s1 == e1) return new TreeNode(preorder[s1]);

        TreeNode root = new TreeNode(preorder[s1]);
        int i = s2;
        for (; i <= e2; i++) {
            if (preorder[s1] == inorder[i]) break;
        }
        root.left = buildTree(preorder, inorder, s1 + 1, s1 + (i - s2), s2, i - 1);
        root.right = buildTree(preorder, inorder, s1 + 1 + (i - s2), s1 + (i - s2) + (e2 - i), i + 1, e2);
        return root;

    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String args[]) {
        int a[] = {5, 4, 2, 11, 1, 12, 3, 9, 10};
        int b[] = {11, 2, 4, 1, 12, 5, 9, 3, 10};
        System.out.println(buildTree(a, b));
        inOrder(buildTree(a, b));
        System.out.println();
        preOrder(buildTree(a, b));
    }
}
