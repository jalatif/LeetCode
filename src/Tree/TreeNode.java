package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manshu on 12/27/14.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
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

    public void inOrder() {
        inOrder(this);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    @Override
    public String toString() {
        List<List<Integer>> lorder = levelOrder(this);
        StringBuilder treeString = new StringBuilder("");
        for (int i = 0; i < lorder.size(); i++){
            treeString.append("[");
            for (int j = 0; j < lorder.get(i).size(); j++){
                treeString.append(lorder.get(i).get(j) + " ");
            }
            treeString.append("]\n");
        }
        return treeString.toString();
    }
}
