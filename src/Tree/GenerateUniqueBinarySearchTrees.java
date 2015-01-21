package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 1/16/15.
 */
public class GenerateUniqueBinarySearchTrees {

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();

        if (start > end){
            treeNodes.add(null);
            return treeNodes;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            treeNodes.add(node);
            return treeNodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            for (TreeNode l : left)
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l; root.right = r;
                    treeNodes.add(root);
                }
        }
        return treeNodes;
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(5);
        System.out.println("Size = " + treeNodes.size());
        for (TreeNode root : treeNodes) {
            System.out.println("==================");
            System.out.println(root);
            System.out.println("==================");
        }
    }
}
