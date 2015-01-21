package Graph;

import java.util.*;

/**
 * Created by manshu on 1/9/15.
 */
public class ReverseGraph {

    private static class QueueItem {
        String vertex;
        int level;
        QueueItem(String s, int i) {
            vertex = s;
            level = i;
        }
    }
    public static void topolicalSort(MyGraph graph) {
        int size = graph.size();
        int indegree[] = new int[size];
        Queue<QueueItem> queue = new LinkedList<QueueItem>();
        List<String> adjacent;
        Iterator<Vertex> vertexIterator = graph.getVertices();
        Vertex vertices[] = new Vertex[size];
        HashMap<Vertex, Integer> vertex_indices = new HashMap<Vertex, Integer>();

        for (int i = 0; i < size; i++) {
            vertices[i] = vertexIterator.next();
            vertex_indices.put(vertices[i], i);
            indegree[i] = vertices[i].indegree;
            if (indegree[i] == 0) {
                queue.add(new QueueItem(vertices[i].label, 0));
            }
        }
        queue.add(null);

        QueueItem queueItem;
        String current = "";
        int count = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            queueItem = queue.poll();
            if (queueItem == null) {
                level++;
                if (!queue.isEmpty())
                    queue.add(null);
                continue;
            }
            current = queueItem.vertex;
            System.out.println(++count + " Level " + queueItem.level + " -> " + current);
            adjacent = graph.getAdjacentVertexNames(current);
            for (String neighbor : adjacent) {
                if (--indegree[vertex_indices.get(graph.getVertex(neighbor))] == 0)
                    queue.add(new QueueItem(neighbor, level));
            }
        }

    }

    static Vertex vertices[];
    static HashMap<Vertex, Integer> vertex_indices;
    static List<String> adjacent;
    static boolean marked[];

    private static void dfs(MyGraph graph, String prev, String vertex) {
        Vertex v = graph.getVertex(vertex);
        int index = vertex_indices.get(v);

        Edge edge = null;
        if (prev != null) {
            edge = graph.getConnection(prev, vertex);
            //System.out.println(prev + "->" + vertex);
            if (marked[index]) System.out.println(edge);
            graph.addDelay();
            graph.removeEdge(edge);
            System.out.println("Removing edge " + edge);
        }
        if (marked[index]) {
            graph.addDelay();
            if (edge != null) {
                graph.addEdge(edge.dest.label, edge.src.label, edge.label, edge.weight);
                System.out.println("Adding edge back " + edge);
            }
            return;
        }
        if (prev == null)
            System.out.println("Starting at Vertex = " + vertex);
        else
            System.out.println(edge);
        marked[index] = true;
        adjacent = graph.getAdjacentVertexNames(vertex);
        for (String neighbor : adjacent) {
            dfs(graph, vertex, neighbor);
        }
        graph.addDelay();
        if (edge != null) {
            graph.addEdge(edge.dest.label, edge.src.label, edge.label, edge.weight);
            System.out.println("Adding edge back " + edge);
        }

    }
    public static void dfs(MyGraph graph) {
        int size = graph.size();
        int indegree[] = new int[size];
        Iterator<Vertex> vertexIterator = graph.getVertices();
        vertices = new Vertex[size];
        vertex_indices = new HashMap<Vertex, Integer>();
        marked = new boolean[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = vertexIterator.next();
            vertex_indices.put(vertices[i], i);
            indegree[i] = vertices[i].indegree;
            marked[i] = false;
        }
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                System.out.println("Calling DFS on " + vertices[i].label);
                dfs(graph, null, vertices[i].label);
            }
        }

    }


    public static void main(String args[]) {
        MyGraph graph = new MyGraph("try1", true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("E", "D");
        graph.addEdge("E", "F");
        graph.addEdge("D", "F");

        //graph.displayGraph(true);

        //graph = reverseGraph(graph);

        MyGraph graph2 = new MyGraph("tsort", true);
        graph2.addVertex("2");
        graph2.addVertex("3");
        graph2.addVertex("5");
        graph2.addVertex("7");
        graph2.addVertex("8");
        graph2.addVertex("9");
        graph2.addVertex("10");
        graph2.addVertex("11");

        graph2.addEdge("11", "2");
        graph2.addEdge("11", "9");
        graph2.addEdge("11", "10");
        graph2.addEdge("8", "9");
        graph2.addEdge("7", "8");
        graph2.addEdge("7", "11");
        graph2.addEdge("5", "11");
        graph2.addEdge("3", "8");
        graph2.addEdge("3", "10");

        //graph2.displayGraph(true);
        //topolicalSort(graph2);

        graph.displayGraph(true);
        dfs(graph);
        topolicalSort(graph);
    }
}
