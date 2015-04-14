package Backtracking;

/**
 * Created by manshu on 3/10/15.
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        int[] assignment = new int[9];


        for (int start = 0; start < 9; start++) {
            for (int var = 0; var < 9; var++) {
                if (var == start) continue;
                for (int val = 1; val < n; val++) {
                    assignment[var] = val;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 5));
    }
}
