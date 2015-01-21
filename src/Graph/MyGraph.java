package Graph;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.AdjacencyListNode;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.graph.implementations.SingleNode;
import org.graphstream.ui.graphicGraph.GraphicNode;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;

import java.util.*;

/**
 * Created by manshu on 1/9/15.
 */

class Vertex {
    String label;
    int indegree;
    int outdegree;
    public Vertex(String label) {
        this.label = label;
        indegree = 0;
        outdegree = 0;
    }

    @Override
    public String toString() {
        return this.label;
    }
}

class Edge {
    Vertex src;
    Vertex dest;
    String label;
    int weight;
    boolean directed;

    public Edge(Vertex src, Vertex dest, String label, int weight, boolean directed) {
        this.src = src;
        this.dest = dest;
        this.label = label;
        this.weight = weight;
        this.directed = directed;
    }

    @Override
    public String toString() {
        return this.src + " >>(" + this.label + ", " + this.weight + ")>> " + this.dest;
    }
}

public class MyGraph {

    private boolean directed;
    private String graphName;
    private List<Vertex> vertices;
    private List<Edge> edges;
    private HashMap<String, LinkedList<Edge>> adjacentEdges;
    private int numVertices;
    private int numEdges;
    private HashMap<String, Vertex> vertexHashMap;
    private HashMap<String, Edge> edgeHashMap;

    /// Visual Graph Settings
    private Graph vGraph;

    private void initGraph(String graphName, boolean directed) {
        this.graphName = graphName;
        this.directed = directed;
        vertices = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        adjacentEdges = new HashMap<String, LinkedList<Edge>>();
        vertexHashMap = new HashMap<String, Vertex>();
        edgeHashMap = new HashMap<String, Edge>();
        numVertices = 0;
        numEdges = 0;

        vGraph = new SingleGraph(graphName);
        vGraph.setAutoCreate(true);
        //vGraph.setStrict(false);

        String css = "node {shape: box;size:30px;fill-color:red;stroke-mode:plain;stroke-color:blue;text-mode:normal;} " +
                "edge {size:10px;fill-color:black;arrow-size:20px,10px;text-mode:normal;}";

        String css1 = "graph {\n" +
                "    padding: 40px;\n" +
                "}\n" +
                "node {\n" +
                "    size: 30px;\n" +
                "    shape: circle;\n" +
                "    fill-mode: plain;\n" +
                "    fill-color: green;\n" +
                "    stroke-mode: plain;\n" +
                "    stroke-color: yellow;\n" +
                "    text-size: 40px;\n" +
                "    text-style: bold;\n" +
                "    text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: red;\n" +
                "}\n" +
                "node:clicked {\n" +
                "    fill-color: red;\n" +
                "}\n" +
                "edge {size:10px;fill-color:black;arrow-size:20px,10px;text-alignment: at-right; text-padding: 3px, 2px; text-background-mode: rounded-box; text-background-color: #EB2; text-color: blue; text-size:20px;\n}";
        vGraph.addAttribute("ui.stylesheet", css1);
        //vGraph.addAttribute("ui.stylesheet", "graph { fill-color: red; }");
        vGraph.addAttribute("ui.quality");
        vGraph.addAttribute("ui.antialias");

    }

    public MyGraph(String graphName, boolean directed) {
        initGraph(graphName, directed);
    }

    public MyGraph(String graphName) {
        initGraph(graphName, false);
    }

    public int size() {
        return numVertices;
    }

    public int edgeSize() {
        return numEdges;
    }

    public Vertex getVertex(String s) {
        return vertexHashMap.get(s);
//        for (Vertex v : vertices)
//            if (v.label.equals(s))
//                return v;
//        return null;
    }

    public Edge getEdgeByName(String s) {
        return edgeHashMap.get(s);
    }

    public void addVertex(String s) {
        Vertex v = getVertex(s);
        if (v != null) {
            throw new IdAlreadyInUseException("Node with id = " + s + " is already in use.");
        }
        v = new Vertex(s);
        vertices.add(v);
        vertexHashMap.put(s, v);
        adjacentEdges.put(s, new LinkedList<Edge>());
        numVertices++;

        vGraph.addNode(s);
    }

    public Iterator<Vertex> getVertices() {
        return vertices.iterator();
    }

    public Iterator<Edge> getEdges() {
        return edges.iterator();
    }

    public void displayGraph(boolean close) {
        for (Node node: vGraph.getNodeSet())
            node.setAttribute("ui.label", node.getId());
        for (org.graphstream.graph.Edge edge: vGraph.getEdgeSet())
            edge.setAttribute("ui.label", edge.getId());
        Viewer viewer = vGraph.display();
        if (close)
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT);
        else
            viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.CLOSE_VIEWER);
        //View view = viewer.getDefaultView();
        //view.getCamera().setViewPercent(0.5);
    }

    public Iterator<Edge> getAdjacent(String s) {
        Vertex v = getVertex(s);
        if (v == null) {
            throw new ElementNotFoundException("Node with id " + s + " not found.");
        }
        //Iterator<Edge> connections = adjacentEdges.get(v.index).iterator();
        return adjacentEdges.get(s).iterator();
    }

    public List<String> getAdjacentVertexNames(String s) {
        Iterator<Edge> iterator = getAdjacent(s);
        List<String> adjVertices = new ArrayList<String>();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            if (directed) {
                adjVertices.add(edge.dest.label);
            } else {
                if (edge.dest.label.equals(s))
                    adjVertices.add(edge.src.label);
                else
                    adjVertices.add(edge.dest.label);
            }
        }
        return adjVertices;
    }


    public void addEdge(String src, String dest, String label, int weight) {
        Vertex v1 = getVertex(src);
        Vertex v2 = getVertex(dest);
        Edge edge = new Edge(v1, v2, label, weight, directed);
        edges.add(edge);
        edgeHashMap.put(label, edge);
        numEdges++;
        adjacentEdges.get(src).addFirst(edge);
        v1.outdegree++;
        v2.indegree++;
        if (!directed) {
            adjacentEdges.get(dest).addFirst(edge);
            v1.indegree++; v2.outdegree++;
        }

        vGraph.addEdge(label, src, dest, directed);
    }

    public void addEdge(String src, String dest) {
        addEdge(src, dest, src+dest, 1);
    }

    public void addEdge(String src, String dest, String label) {
        addEdge(src, dest, label, 1);
    }

    public void addEdge(String src, String dest, int weight) {
        addEdge(src, dest, src+dest, weight);
    }

    public String randomVertex() {
        Random random = new Random();
        int rand = random.nextInt(size() + 1);
        return vertices.get(rand).label;
    }

    public void removeVertex(Vertex v) {

        List<Edge> remEdge = new ArrayList<Edge>();
        for (int i = 0; i < numEdges; i++) {
            Edge edge = edges.get(i);
            if (edge.src.label.equals(v.label) || edge.dest.label.equals(v.label))
                remEdge.add(edge);
        }

        for (Edge edge: remEdge)
            removeEdge(edge);

        vertices.remove(v);
        numVertices--;
        vertexHashMap.remove(v.label);
        adjacentEdges.remove(v.label);

        vGraph.removeNode(v.label);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
        numEdges--;
        edgeHashMap.remove(edge.label);
        Vertex src = edge.src;
        Vertex dest = edge.dest;
        adjacentEdges.get(src.label).remove(edge);
        src.outdegree--;dest.indegree--;
        if (!directed) {
            adjacentEdges.get(dest.label).remove(edge);
            dest.outdegree--; src.indegree--;
        }

        vGraph.removeEdge(edge.label);
    }

    public Edge getConnection(String src, String dest) {

        Iterator<Edge> edgeIterator = getAdjacent(src);
        while (edgeIterator.hasNext()) {
            Edge edge = edgeIterator.next();
            if (directed) {
                if (edge.dest.label.equals(dest))
                    return edge;
            } else {
                if (edge.dest.label.equals(dest) || edge.src.label.equals(dest))
                    return edge;
            }

        }
        return null;
    }
    
    public void addDelay() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
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

        graph.displayGraph(true);



        List<String> vs = graph.getAdjacentVertexNames("B");
        for (String s : vs)
            System.out.println(s);

        graph.addDelay();
        graph.removeEdge(graph.getEdgeByName("AB"));
        graph.addDelay();
        graph.removeVertex(graph.getVertex("D"));
        graph.addDelay();
        graph.removeEdge(graph.getEdgeByName("EF"));

        graph.addDelay();
        graph.removeVertex(graph.getVertex("C"));

        graph.addDelay();
        graph.removeVertex(graph.getVertex("A"));

        graph.addDelay();
        graph.removeVertex(graph.getVertex("B"));

        graph.addDelay();
        graph.removeVertex(graph.getVertex("E"));

        graph.addDelay();
        graph.removeVertex(graph.getVertex("F"));

    }

}
