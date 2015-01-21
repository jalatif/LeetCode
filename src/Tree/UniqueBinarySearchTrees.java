package Tree;

/**
 * Created by manshu on 1/16/15.
 */
public class UniqueBinarySearchTrees {
    private static int numTrees(int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        int totalTrees = 0;
        //System.out.println("start = " + start + " end = " + end);
        for (int i = start; i <= end; i++) {
            int left = numTrees(start, i - 1);
            int right = numTrees(i + 1, end);
            if (left == 0 && right == 0) totalTrees += 1;
            else if (left != 0 && right != 0) totalTrees += left * right;
            else if (left != 0) totalTrees += left;
            else if (right != 0) totalTrees += right;
            //System.out.println("\t\tI = " + i + " tree = " + totalTrees);
        }
        //System.out.println("start = " + start + " end = " + end + " tree = " + totalTrees);
        return totalTrees;
    }

    public static int numTrees(int n) {
        return numTrees(1, n);
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
