package edu.ufmg.dcc849;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.graph.Graph;
import edu.ufmg.dcc849.graph.Kruskal;
import edu.ufmg.dcc849.graph.Vertice;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.QuickSort;
import edu.ufmg.dcc849.sort.linear.BucketSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 5/10/16.
 */
public class Main {

    public static void main(String args[]) {

        Graph<Integer> graph = new Graph<Integer>();

        // graph based on this link: https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");
        Vertice g = new Vertice("g");

        graph.addVertice(a);
        graph.addVertice(b);
        graph.addVertice(c);
        graph.addVertice(d);
        graph.addVertice(e);
        graph.addVertice(f);
        graph.addVertice(g);

        graph.addEdge(new Edge<Integer>(a, b, 7));
        graph.addEdge(new Edge<Integer>(a, d, 5));
        graph.addEdge(new Edge<Integer>(b, c, 8));
        graph.addEdge(new Edge<Integer>(b, d, 9));
        graph.addEdge(new Edge<Integer>(b, e, 7));
        graph.addEdge(new Edge<Integer>(c, e, 5));
        graph.addEdge(new Edge<Integer>(d, e, 15));
        graph.addEdge(new Edge<Integer>(d, f, 6));
        graph.addEdge(new Edge<Integer>(e, f, 8));
        graph.addEdge(new Edge<Integer>(e, g, 9));
        graph.addEdge(new Edge<Integer>(f, g, 11));

        Sort<Edge<Integer>> bucketSort = new BucketSort();
        Kruskal<Integer> kruskal = new Kruskal<Integer>(bucketSort);

        List<Edge<Integer>> mst = kruskal.execute(graph);

        for (Edge<Integer> edge : mst) {
            System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestiny().getName() + " = " + edge.getValue());
        }
    }
}
