package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manshu on 1/10/15.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x; neighbors = new ArrayList<UndirectedGraphNode>();
    }

    private void dfs() {

    }
    @Override
    public String toString() {
        return "";
    }
}
