package test.sort;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.graph.Vertice;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.linear.BucketSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 5/31/16.
 */
public class LinearSortTest {

    List<Edge<Integer>> unsortedList;

    List<Edge<Integer>> sortedList;

    Sort<Edge<Integer>> sortingAlgorithm;

    @org.junit.Before
    public void setUp() throws Exception {

        unsortedList = new ArrayList<Edge<Integer>>();
        sortedList = new ArrayList<Edge<Integer>>();

        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");
        Vertice g = new Vertice("g");

        unsortedList.add(new Edge<Integer>(a, b, 7));
        unsortedList.add(new Edge<Integer>(a, d, 5));
        unsortedList.add(new Edge<Integer>(b, c, 8));
        unsortedList.add(new Edge<Integer>(b, d, 9));
        unsortedList.add(new Edge<Integer>(b, e, 12));
        unsortedList.add(new Edge<Integer>(c, e, 1));
        unsortedList.add(new Edge<Integer>(d, e, 15));
        unsortedList.add(new Edge<Integer>(d, f, 6));
        unsortedList.add(new Edge<Integer>(e, f, 3));
        unsortedList.add(new Edge<Integer>(e, g, 4));
        unsortedList.add(new Edge<Integer>(f, g, 11));


        sortedList.add(new Edge<Integer>(c, e, 1));
        sortedList.add(new Edge<Integer>(e, f, 3));
        sortedList.add(new Edge<Integer>(e, g, 4));
        sortedList.add(new Edge<Integer>(a, d, 5));
        sortedList.add(new Edge<Integer>(d, f, 6));
        sortedList.add(new Edge<Integer>(a, b, 7));
        sortedList.add(new Edge<Integer>(b, c, 8));
        sortedList.add(new Edge<Integer>(b, d, 9));
        sortedList.add(new Edge<Integer>(f, g, 11));
        sortedList.add(new Edge<Integer>(b, e, 12));
        sortedList.add(new Edge<Integer>(d, e, 15));
    }

}
