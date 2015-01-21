package Graph;

import java.util.*;

/**
 * Created by manshu on 1/10/15.
 */
public class CloneGraph {
//    private class QueueItem {
//        UndirectedGraphNode source;
//        UndirectedGraphNode destination;
//        QueueItem(UndirectedGraphNode u1, UndirectedGraphNode u2) {
//            this.source = u1;
//            this.destination = u2;
//        }
//    }
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.add(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node, newNode);

        UndirectedGraphNode current;

        while (!queue.isEmpty()) {
            current = queue.poll();
            if (visited.containsKey(current))
                continue;
            UndirectedGraphNode otherNode;
            for (UndirectedGraphNode neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    otherNode = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, otherNode);
                    visited.get(current).neighbors.add(otherNode);
                } else {
                    visited.get(current).neighbors.add(visited.get(neighbor));
                }
            }
        }
        return visited.get(node);
    }

    public static void main(String args[]) {
        UndirectedGraphNode undirectedGraphNode = new UndirectedGraphNode(0);
        undirectedGraphNode.neighbors.add(new UndirectedGraphNode(1));
        undirectedGraphNode.neighbors.add(new UndirectedGraphNode(2));
        undirectedGraphNode.neighbors.get(0).neighbors.add(undirectedGraphNode.neighbors.get(1));
        undirectedGraphNode.neighbors.get(1).neighbors.add(undirectedGraphNode.neighbors.get(1));

        cloneGraph(undirectedGraphNode);
    }
}
