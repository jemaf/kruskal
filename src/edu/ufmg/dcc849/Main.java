package edu.ufmg.dcc849;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.graph.Kruskal;
import edu.ufmg.dcc849.graph.Vertice;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 5/10/16.
 */
public class Main {

    public static void main(String args[]) {

        List<Vertice> verticeList = new ArrayList<Vertice>();
        List<Edge<Integer>> edgeList = new ArrayList<Edge<Integer>>();

        // graph based on this link: https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");
        Vertice g = new Vertice("g");

        verticeList.add(a);
        verticeList.add(b);
        verticeList.add(c);
        verticeList.add(d);
        verticeList.add(e);
        verticeList.add(f);
        verticeList.add(g);

        edgeList.add(new Edge<Integer>(a, b, 7));
        edgeList.add(new Edge<Integer>(a, d, 5));
        edgeList.add(new Edge<Integer>(b, c, 8));
        edgeList.add(new Edge<Integer>(b, d, 9));
        edgeList.add(new Edge<Integer>(b, e, 7));
        edgeList.add(new Edge<Integer>(c, e, 5));
        edgeList.add(new Edge<Integer>(d, e, 15));
        edgeList.add(new Edge<Integer>(d, f, 6));
        edgeList.add(new Edge<Integer>(e, f, 8));
        edgeList.add(new Edge<Integer>(e, g, 9));
        edgeList.add(new Edge<Integer>(f, g, 11));

        Sort<Edge<Integer>> quickSort = new QuickSort<Edge<Integer>>();
        Kruskal<Integer> kruskal = new Kruskal<Integer>(quickSort);

        List<Edge<Integer>> mst = kruskal.execute(edgeList, verticeList);

        for (Edge<Integer> edge : mst) {
            System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestiny().getName() + " = " + edge.getValue());
        }
    }
}
