package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;

import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class RadixSort implements Sort<Edge<Integer>> {


    private static int digNumOfMax(List<Edge<Integer>> edgeArray) {
        int max = Integer.MIN_VALUE;

        for(Edge<Integer> edge: edgeArray){
            if(max < edge.getValue()) {
                max = edge.getValue();
            }
        }
        return String.valueOf(max).length();
    }

    @Override
    public List<Edge<Integer>> sort(List<Edge<Integer>> unsortedList) {
        int digNum = digNumOfMax(unsortedList);

        for(int i = 1; i <= digNum; i++) {
            unsortedList = (new CountingSort()).runSortDigit(unsortedList, i);
        }

        return unsortedList;
    }
}
