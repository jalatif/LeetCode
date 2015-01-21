package Graph;

/**
 * Created by manshu on 1/9/15.
 */

import org.graphstream.algorithm.Kruskal;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.DefaultGraph;
import org.graphstream.graph.implementations.SingleGraph;

public class GraphDemo {

    public static void main(String args[]) {
        Graph graph = new SingleGraph("First");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.setAutoCreate( true );
        graph.addEdge("AB", "A", "B");

        graph.display();

        Graph graph1 = new SingleGraph("Random");
        Generator gen = new RandomGenerator(2);
        gen.addSink(graph1);
        gen.begin();
        for(int i=0; i<100; i++)
            gen.nextEvents();
        gen.end();
        graph1.display();

        DorogovtsevMendesGenerator gen2 = new DorogovtsevMendesGenerator();
        Graph graph2 = new DefaultGraph("Kruskal Test");

        String css = "edge .notintree {size:1px;fill-color:gray;} " +
                "edge .intree {size:3px;fill-color:black;}";

        graph2.addAttribute("ui.stylesheet", css);
        graph2.display();

        gen2.addEdgeAttribute("weight");
        gen2.setEdgeAttributesRange(1, 100);
        gen2.addSink(graph2);
        gen2.begin();
        for (int i = 0; i < 100 && gen2.nextEvents(); i++)
            ;
        gen2.end();

        Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree");

        kruskal.init(graph2);
        kruskal.compute();
    }
}
