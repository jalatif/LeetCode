package General;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by manshu on 3/17/15.
 */

class TrieNode {
    char data;
    int ends;
    protected List<TrieNode> childs;
    public TrieNode(char c) {
        data = c;
        ends = 0;
        childs = new LinkedList<TrieNode>();
    }

    public TrieNode getSubNode(char c) {
        for (TrieNode node : childs) {
            if (node.data == c) return node;
        }
        return null;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }


    private void insertString(TrieNode root, String s, int start) {
        if (start == s.length()) {
            root.ends += 1;
            return;
        }
        TrieNode subNode = root.getSubNode(s.charAt(start));
        if (subNode == null) {
            subNode = new TrieNode(s.charAt(start));
            root.childs.add(subNode);
        }
        insertString(subNode, s, start + 1);
    }

    public void insertString(String s) {
        insertString(root, s, 0);
    }

    private boolean searchString(TrieNode root, String s, int start) {
        if (start == s.length()) return root.ends != 0;
        TrieNode subNode = root.getSubNode(s.charAt(start));
        if (subNode == null) return false;
        return searchString(subNode, s, start + 1);
    }

    public boolean searchString(String s) {
        return searchString(root, s, 0);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertString("abcd");
        System.out.println(trie.searchString("abcD"));
    }
}
