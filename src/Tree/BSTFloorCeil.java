package Tree;

/**
 * Created by manshu on 1/1/15.
 */
public class BSTFloorCeil {

    public static TreeNode floor(TreeNode root, int x) {
        if (root == null || root.val == x) return root;
        else if (x < root.val)
            return floor(root.left, x);
        else {
            TreeNode temp = floor(root.right, x);
            if (temp == null)
                return root;
            else {
                if (temp.val > root.val) return temp;
                else return root;
            }
        }
    }

    public static TreeNode ceil(TreeNode root, int x) {
        if (root == null || root.val == x) return root;
        else if (x > root.val)
            return ceil(root.right, x);
        else {
            TreeNode temp = ceil(root.left, x);
            if (temp == null)
                return root;
            else {
                if (temp.val < root.val) return temp;
                else return root;
            }
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
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

        inOrder(root);
        System.out.println();
        System.out.println(floor(root, 101).val);
        System.out.println(ceil(root, 99).val);

    }
}
