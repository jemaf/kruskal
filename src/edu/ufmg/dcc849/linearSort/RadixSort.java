package edu.ufmg.dcc849.linearSort;

import edu.ufmg.dcc849.graph.Edge;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class RadixSort {
    public void runSort(Edge[] edgesToSort) {
        int digNum = digNumOfMax(edgesToSort);

        for(int i = 1; i <= digNum; i++) {
            edgesToSort = new CountingSort().runSortDigit(edgesToSort,i);
        }
    }

    private static int digNumOfMax(Edge[] edgeArray) {
        int max = Integer.MIN_VALUE;

        for(Edge edge: edgeArray){
            if(max < (int)edge.getValue()) {
                max = (int)edge.getValue();
            }
        }
        return String.valueOf(max).length();
    }
}
