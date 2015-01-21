package Tree;

/**
 * Created by manshu on 12/31/14.
 */
public class MaxPathSum {

    private static int maxSum;
    private static int maxPathSumUtils(TreeNode root) {
        if (root == null) return 0;
        //return root.val + maxPathSum(root.left) + maxPathSum(root.right);
        int left = maxPathSumUtils(root.left);
        int right = maxPathSumUtils(root.right);

        int current_sum = root.val;
        if (left > 0) current_sum += left;
        if (right > 0) current_sum += right;

        if (current_sum > maxSum) maxSum = current_sum;

        if (left > 0 && right > 0) {current_sum -= Math.min(left, right);}

        return current_sum;
    }

    private static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumUtils(root);
        return maxSum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(-7);

//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(10);

        System.out.println(root);
        System.out.println(maxPathSum(root));
    }
}
