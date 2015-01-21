package Tree;

/**
 * Created by manshu on 1/2/15.
 */
public class SortedArrayToBST {
    private static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(num[start]);

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public static void main(String args[]) {
        int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = sortedArrayToBST(num);
        System.out.println(root);
        root.inOrder();
    }
}
