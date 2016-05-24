package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;

import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
//
//  TODO fix this class
public class RadixSort<T extends Comparable<T>> implements Sort<T> {

//    public void runSort(Edge[] edgesToSort) {
//        int digNum = digNumOfMax(edgesToSort);
//
//        for(int i = 1; i <= digNum; i++) {
//            edgesToSort = new CountingSort().runSortDigit(edgesToSort,i);
//        }
//    }
//
//    private static int digNumOfMax(Edge[] edgeArray) {
//        int max = Integer.MIN_VALUE;
//
//        for(Edge edge: edgeArray){
//            if(max < (int)edge.getValue()) {
//                max = (int)edge.getValue();
//            }
//        }
//        return String.valueOf(max).length();
//    }

    @Override
    public List<T> sort(List<T> unsortedList) {
        return null;
    }
}
