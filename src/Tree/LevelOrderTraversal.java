package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manshu on 12/30/14.
 */
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return null;

        queue.add(root);
        queue.add(null);

        TreeNode temp;
        int level = 1;

        //System.out.println("\nLevel = " + level);

        List<Integer> level_data = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == null) {
                result.add(level_data);
                level_data = new ArrayList<Integer>();

                queue.add(null);
                temp = queue.poll();
                if (temp == null) break;
                level += 1;
                //System.out.println("\nLevel = " + level);

            }

            //System.out.print(temp.val + " ");
            level_data.add(temp.val);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);

        List<List<Integer>> lorder = levelOrder(root);
        for (int i = 0; i < lorder.size(); i++){
            System.out.print("[");
            for (int j = 0; j < lorder.get(i).size(); j++){
                System.out.print(lorder.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
    }
}
