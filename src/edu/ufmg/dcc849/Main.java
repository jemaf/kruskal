package edu.ufmg.dcc849;

import edu.ufmg.dcc849.graph.*;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.QuickSort;
import edu.ufmg.dcc849.sort.linear.BucketSort;
import edu.ufmg.dcc849.sort.linear.CountingSort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 5/10/16.
 */
public class Main {

    public static void main(String args[]) throws IOException {

        CompleteGraphGenerator generator = new CompleteGraphGenerator(500, 50000, 1);
        Graph testGraph = generator.run();

        List<Edge<Integer>> edgeList = testGraph.getEdges();

        System.out.println("Original Edges:");

        for (Edge<Integer> edge : edgeList) {
            System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestiny().getName() + " = " + edge.getValue());
        }

        Sort<Edge<Integer>> countingSort = new CountingSort();
        Kruskal<Integer> kruskal = new Kruskal<Integer>(countingSort);

        List<Edge<Integer>> mst = kruskal.execute(testGraph);

        System.out.println("Edges from the MST:");

        for (Edge<Integer> edge : mst) {
            System.out.println(edge.getOrigin().getName() + " -> " + edge.getDestiny().getName() + " = " + edge.getValue());
        }
    }
}
