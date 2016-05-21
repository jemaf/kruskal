package edu.ufmg.dcc849.comparedSort;

import edu.ufmg.dcc849.graph.Edge;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class InsertionSort {
    public void runSort(Edge[] edgesToSort) {
        for(int i = 1; i < edgesToSort.length; i++) {
            Edge currEdge = edgesToSort[i];

            int j = i - 1;

            while((j > 0) && (currEdge.compareTo(edgesToSort[j]) < 0)) {
                edgesToSort[j+1] = edgesToSort[j];
                j--;
            }

            edgesToSort[j+1] = currEdge;
        }
    }
}
