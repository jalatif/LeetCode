package Tree;

/**
 * Created by manshu on 1/15/15.
 */
public class BuildTreeFromInPostOrdering {
    private static TreeNode buildTree(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        //System.out.println(s1 + " " + e1 + ", " + s2 + " " + e2);
        if (s1 > e1) return null;
        if (s1 == e1) return new TreeNode(postorder[e2]);

        TreeNode root = new TreeNode(postorder[e2]);
        int i = s1;
        for (; i <= e1; i++) {
            if (postorder[e2] == inorder[i]) break;
        }
        root.left = buildTree(inorder, postorder, s1, i - 1, s2, s2 + (i - s1) - 1);
        root.right = buildTree(inorder, postorder, i + 1, e1, s2 + (i - s1), e2 - 1);
        return root;

    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + ", ");
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + ", ");
    }


    public static void main(String args[]) {
        int a[] = {11, 2, 4, 1, 12, 5, 9, 3, 10};
        int b[] = {11, 2, 12, 1, 4, 9, 10, 3, 5};
        System.out.println(buildTree(a, b));
        inOrder(buildTree(a, b));
        System.out.println();
        postOrder(buildTree(a, b));
    }
}
