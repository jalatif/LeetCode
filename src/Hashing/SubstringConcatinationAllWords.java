package Hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 4/11/15.
 */


public class SubstringConcatinationAllWords {

    static class TSTNode {
        char data;
        int num_end;
        TSTNode left;
        TSTNode eq;
        TSTNode right;
        public TSTNode(char data) {
            this.data = data;
            num_end = 0;
            left = null;
            eq = null;
            right = null;
        }
    }

    static class TernarySearchTree {
        private TSTNode root;
        private boolean hasEmpty;
        public TernarySearchTree() {
            root = null;
            hasEmpty = false;
        }

        private TSTNode insert(TSTNode node, String s, int index) {
            if (node == null) {
                node = new TSTNode(s.charAt(index));
            }
            if (index == s.length() - 1) {
                node.num_end += 1;
                return node;
            }

            if (node.data < s.charAt(index)) {
                node.right = insert(node.right, s, index);
            } else if (node.data > s.charAt(index)) {
                node.left = insert(node.left, s, index);
            } else {
                node.eq = insert(node.eq, s, index + 1);
            }
            return node;
        }

        public void add(String s) {
            if (s == null) {
                System.out.println("Cannot insert null string");
                return;
            }
            if (s.length() == 0) {
                hasEmpty = true;
                return;
            }
            root = insert(root, s, 0);
        }

        private boolean search(TSTNode node, String s, int index) {
            if (node == null) return false;
            if (index == s.length() - 1) {
                return node.num_end > 0 && node.data == s.charAt(index);
            }
            if (node.data < s.charAt(index)) {
                return search(node.right, s, index);
            } else if (node.data > s.charAt(index)) {
                return search(node.left, s, index);
            } else {
                return search(node.eq, s, index + 1);
            }
        }

        public boolean contains(String s) {
            if (s == null) return false;
            if (s.length() == 0) return hasEmpty;
            return search(root, s, 0);
        }

    }

    public static List<Integer> findSubstring(String S, String[] L) {
        TernarySearchTree tst = new TernarySearchTree();

        for (String word : L) tst.add(word);

        int n = L[0].length();

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i <= S.length() - n; i++) {
            String subString = S.substring(i, i + n);
            if (!tst.contains(subString)) continue;
            int last = i;
            int done = 1;
            TernarySearchTree covered = new TernarySearchTree();
            covered.add(subString);
            i += n;
            while ((i + n) < S.length()) {
                subString = S.substring(i, i + n);
                if (!tst.contains(subString)) break;
                if (covered.contains(subString)) break;
                done++;
                if (done == L.length) {
                    break;
                }
                i += n;
            }
            if (done == L.length) result.add(last);
            i = last;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aaa", new String[]{"a", "a"}));

        //System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
