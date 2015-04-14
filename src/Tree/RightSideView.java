package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manshu on 4/10/15.
 */
public class RightSideView {

//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        if (root == null) return result;
//        List<Integer> l = rightSideView(root.left);
//        List<Integer> r = rightSideView(root.right);
//
//        result.add(root.val);
//        result.addAll(r);
//        if (r.size() >= l.size()) {
//            ;
//        } else {
//            for (int i = r.size(); i < l.size(); i++)
//                result.add(l.get(i));
//        }
//        return result;
//    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        TreeNode prev = null, current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == null) {
                result.add(prev.val);
                if (!queue.isEmpty()) queue.add(null);
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            prev = current;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        root.right.left.left.left = new TreeNode(8);
        root.right.left.left.right = new TreeNode(9);

        root.right.left.left.left.left = new TreeNode(10);




        System.out.println(rightSideView(root));
    }
}
