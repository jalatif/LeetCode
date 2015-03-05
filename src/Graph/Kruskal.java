package Graph;

import java.util.*;

/**
 * Created by manshu on 2/20/15.
 */
public class Kruskal {
    
    private static class StackItem {
        String vertex;
        String previous;
        StackItem(String s1, String s2) {
            vertex = s1; previous = s2;
        }
    }
    
    private static boolean checkCycle(MyGraph graph) {
        String start = graph.getVertices().get(0).label;
        Set<String> explored = new HashSet<String>();
        
        Stack<StackItem> stack = new Stack<StackItem>();
        stack.push(new StackItem(start, null));
        
        StackItem current;
        while (!stack.empty()) {
            current = stack.pop();
            if (explored.contains(current.vertex)) return true;
            explored.add(current.vertex);
            for (String neighbor : graph.getAdjacentVertexNames(current.vertex)) {
                if (current.previous != null && current.previous.equals(neighbor)) continue;
                stack.push(new StackItem(neighbor, current.vertex));
            }
        }
        
        return false;
    }
    
    public static MyGraph kruskalAlgo(MyGraph graph) {
        
        List<Edge> edges = graph.getEdges();
        List<Vertex> vertices = graph.getVertices();
        
        Set<String> vertexSet = new TreeSet<String>();
        
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                Integer i1 = o1.weight;
                Integer i2 = o2.weight;
                return i1.compareTo(i2);
            }
        });
        System.out.println(edges);
        MyGraph tree_graph = new MyGraph("tree", false);
        
        for (Edge edge : edges) {
            if (vertexSet.isEmpty()) {
                vertexSet.add(edge.src.label);
                vertexSet.add(edge.dest.label);
                tree_graph.addVertex(edge.src.label);
                tree_graph.addVertex(edge.dest.label);
                tree_graph.addEdge(edge.src.label, edge.dest.label, edge.label, edge.weight);
            } else {
                if (!vertexSet.contains(edge.src.label)) {
                    vertexSet.add(edge.src.label);
                    tree_graph.addVertex(edge.src.label);
                }
                if (!vertexSet.contains(edge.dest.label)) {
                    vertexSet.add(edge.dest.label);
                    tree_graph.addVertex(edge.dest.label);
                }
                tree_graph.addEdge(edge.src.label, edge.dest.label, edge.label, edge.weight);
                if (checkCycle(tree_graph)) tree_graph.removeEdge(tree_graph.getEdgeByName(edge.label));
                System.out.println("Forms a cycle " + edge);
            }
            //if (vertexSet.size() == vertices.size()) break;
        }
        
        return tree_graph;
    }

    public static MyGraph kruskalAlgoSet(MyGraph graph) {

        List<Edge> edges = graph.getEdges();
        List<Vertex> vertices = graph.getVertices();
        Set<String> vertexSet = new HashSet<String>();

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                Integer i1 = o1.weight;
                Integer i2 = o2.weight;
                return i1.compareTo(i2);
            }
        });
        System.out.println(edges);
        
        DisjointSet<String> disjointSet = new DisjointSet<String>(vertices.size());
        for (Vertex v : vertices) {
            int sname = disjointSet.makeSet(v.label);
            System.out.println(v.label + " ---> " + sname);
        }
        
        MyGraph tree_graph = new MyGraph("settree", false);

        for (Edge edge : edges) {
            if (vertexSet.isEmpty()) {
                vertexSet.add(edge.src.label);
                vertexSet.add(edge.dest.label);
                tree_graph.addVertex(edge.src.label);
                tree_graph.addVertex(edge.dest.label);
                tree_graph.addEdge(edge.src.label, edge.dest.label, edge.label, edge.weight);
                disjointSet.union(edge.src.label, edge.dest.label);
                System.out.println(edge.src.label + ">>" + edge.dest.label + " ----> " + disjointSet.find(edge.src.label) + " -- " + disjointSet.find(edge.dest.label));
            } else {
                if (!vertexSet.contains(edge.src.label)) {
                    vertexSet.add(edge.src.label);
                    tree_graph.addVertex(edge.src.label);
                }
                if (!vertexSet.contains(edge.dest.label)) {
                    vertexSet.add(edge.dest.label);
                    tree_graph.addVertex(edge.dest.label);
                }
                System.out.println();
                System.out.println(edge.src.label + ">>" + edge.dest.label + " ----> " + disjointSet.find(edge.src.label) + " -- " + disjointSet.find(edge.dest.label));
                if (disjointSet.inSameSet(edge.src.label, edge.dest.label)) {
                    System.out.println("Forms a cycle " + edge);
                    continue;
                }
                disjointSet.union(edge.src.label, edge.dest.label);
                System.out.println(edge.src.label + ">>" + edge.dest.label + " ----> " + disjointSet.find(edge.src.label) + " -- " + disjointSet.find(edge.dest.label));
                tree_graph.addEdge(edge.src.label, edge.dest.label, edge.label, edge.weight);
                
                //if (checkCycle(tree_graph)) tree_graph.removeEdge(tree_graph.getEdgeByName(edge.label));
                
            }
            if (vertexSet.size() == vertices.size()) break;
        }

        return tree_graph;
    }
    
    public static void main(String[] args) {
        MyGraph graph2 = new MyGraph("tsort", false);
        graph2.addVertex("2");
        graph2.addVertex("3");
        graph2.addVertex("5");
        graph2.addVertex("7");
        graph2.addVertex("8");
        graph2.addVertex("9");
        graph2.addVertex("10");
        graph2.addVertex("11");

        graph2.addEdge("11", "2", 5);
        graph2.addEdge("11", "9", 10);
        graph2.addEdge("11", "10", 1);
        //graph2.addEdge("8", "9", 2);
        graph2.addEdge("7", "8", 9);
        graph2.addEdge("7", "11", 8);
        graph2.addEdge("5", "11", 3);
        //graph2.addEdge("3", "8", 6);
        graph2.addEdge("3", "10", 11);
        graph2.addEdge("8", "2", 0);

        //System.out.println(checkCycle(graph2));

        graph2.displayGraph(true);

        //MyGraph treeGraph = kruskalAlgo(graph2);
        //treeGraph.displayGraph(true);
        MyGraph treeGraph2 = kruskalAlgoSet(graph2);
        treeGraph2.displayGraph(true);


        DisjointSet<Integer> set = new DisjointSet<Integer>(8);
        set.makeSet(3);
        set.makeSet(10);
        set.makeSet(11);
        set.makeSet(5);
        set.makeSet(9);
        set.makeSet(2);
        set.makeSet(8);
        set.makeSet(7);

        set.union(11, 2);
        set.union(11, 7);
        //set.union(2, 8);

        System.out.println(set.find(11));
        System.out.println(set.find(2));
        System.out.println(set.find(8));
        System.out.println(set.find(7));
        System.out.println(set.inSameSet(7, 8));





    }
}
