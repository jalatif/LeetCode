package General;

/**
 * Created by manshu on 4/11/15.
 */

class TSTNode {
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

public class TernarySearchTree {
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

    public static void main(String[] args) {
        TernarySearchTree tst = new TernarySearchTree();
        tst.add("abc");
        tst.add("adc");
        System.out.println(tst.contains("abd"));
    }
}
