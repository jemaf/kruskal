package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
//
//    TODO fix this class
public class CountingSort implements Sort<Edge<Integer>> {

    @Override
    public List<Edge<Integer>> sort(List<Edge<Integer>> unsortedList) {

        int[] countLessThan = new int[findMaxEdge(unsortedList).getValue() + 1];

        for(int i = 0; i < countLessThan.length; i++)
            countLessThan[i] = 0;

        for (Edge<Integer> edge : unsortedList)
            countLessThan[edge.getValue()]++;

        //Assuming that there are edges with zero weight
        for(int i = 1; i < countLessThan.length; i++)
            countLessThan[i] = countLessThan[i] + countLessThan[i - 1];

        Edge[] sortedEdges = new Edge[unsortedList.size()];
        for(int i = unsortedList.size() - 1; i >= 0; i--) {
            sortedEdges[countLessThan[unsortedList.get(i).getValue()] - 1] = unsortedList.get(i);
            countLessThan[unsortedList.get(i).getValue()]--;
        }

        List<Edge<Integer>> sortedList = new ArrayList<Edge<Integer>>();
        for (Edge<Integer> edge : sortedEdges)
            sortedList.add(edge);

        return sortedList;
    }


//    public Edge[] runSortDigit(Edge[] edgesToSort, int digitPos) {
//        int[] countLessThan = new int[10];
//
//        for(int i = 0; i < 10; i++){
//            countLessThan[i] = 0;
//        }
//
//        for (Edge edge : edgesToSort) {
//            int digitValue = getDigit((int)edge.getValue(), digitPos);
//            countLessThan[digitValue]++;
//        }
//
//        for(int i = 1; i < 10; i++) {
//            countLessThan[i] += countLessThan[i - 1];
//        }
//
//        Edge[] sortedEdges = new Edge[edgesToSort.length];
//
//        for(int i = edgesToSort.length-1; i >= 0; i--) {
//            int digitValue = getDigit((int)edgesToSort[i].getValue(),digitPos);
//
//            sortedEdges[countLessThan[digitValue]-1] = edgesToSort[i];
//            countLessThan[digitValue]--;
//        }
//
//        return sortedEdges;
//    }

//    private static int getDigit(int value, int digitPos) {
//        int digit = value;
//
//        while(digitPos-- > 1) {
//            digit /= 10;
//        }
//
//        return digit%10;
//    }


    private Edge<Integer> findMaxEdge(List<Edge<Integer>> list) {
        Edge<Integer> maxEdge= list.get(0);

        for(Edge item : list) {
            if(item.compareTo(maxEdge) > 0) {
                maxEdge = item;
            }
        }
        return maxEdge;
    }
}
