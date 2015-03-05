package General;
import Tree.TreeNode;

/**
 * Created by manshu on 2/26/15.
 */
public class VerticalOrderTraversal {

    private static class MinMax {
        int min;
        int max;
        MinMax(int m1, int m2) {min = m1; max = m2;}
        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }
    
    private static void findMinMax(TreeNode root, MinMax mm, int dist) {
        if (root == null) return;
        
        if (dist > mm.getMax()) mm.setMax(dist);
        if (dist < mm.getMin()) mm.setMin(dist);
        
        findMinMax(root.left, mm, dist - 1);
        findMinMax(root.right, mm, dist + 1);
    }
    
    private static void printVertical(TreeNode root, int given_order, int order) {
        if (root == null) return;
        
        if (given_order == order) System.out.print(root.val + " ");
        
        printVertical(root.left, given_order, order - 1);
        printVertical(root.right, given_order, order + 1);
    } 
    
    public static void verticalOrderTraversal(TreeNode root) {
        MinMax mm = new MinMax(0, 0);
        findMinMax(root, mm, 0);
        //System.out.println(mm.getMin() + " " + mm.getMax());
        
        for (int order = mm.getMin(); order <= mm.getMax(); order++) {
            printVertical(root, order, 0);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        
        verticalOrderTraversal(root);
    }
}
