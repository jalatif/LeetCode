package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 12/30/14.
 */
public class PathsWithSum {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lai = new ArrayList<List<Integer>>();

        if (root == null)
            return lai;

        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                lai.add(new ArrayList<Integer>());
                lai.get(0).add(root.val);
                return lai;
            }
            else {
                return lai;
            }
        }
        List<List<Integer>> li = pathSum(root.left, sum - root.val);
        List<List<Integer>> ri = pathSum(root.right, sum - root.val);

        if (li != null){
            for (int i = 0; i < li.size(); i++) {
               li.get(i).add(0, root.val);
            }
        }

        if (ri != null) {
            for (int i = 0; i < ri.size(); i++) {
                ri.get(i).add(0, root.val);
            }
        }

        List<List<Integer>> nli = new ArrayList<List<Integer>>();
        if (li == null && ri == null) return null;

        if (li != null) {
            for (int i = 0; i < li.size(); i++) {
                nli.add(li.get(i));
            }
        }

        if (ri != null) {
            for (int i = 0; i < ri.size(); i++) {
                nli.add(ri.get(i));
            }
        }
        return nli;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(1);

        List<List<Integer>> li = pathSum(root, 18);
        for (int i = 0; i < li.size(); i++){
            System.out.print("[");
            for (int j = 0; j < li.get(i).size(); j++){
                System.out.print(li.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
    }

}
