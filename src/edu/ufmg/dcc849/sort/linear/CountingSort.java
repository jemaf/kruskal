package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class CountingSort implements Sort<Edge<Integer>> {

    @Override
    public List<Edge<Integer>> sort(List<Edge<Integer>> unsortedList) {

        int[] countLessThan = new int[findMaxEdge(unsortedList).getValue() + 1];

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


    public List<Edge<Integer>> runSortDigit(List<Edge<Integer>> edgesToSort, int digitPos) {
        int[] countLessThan = new int[10];

        for (Edge<Integer> edge : edgesToSort) {
            int digitValue = getDigit(edge.getValue(), digitPos);
            countLessThan[digitValue]++;
        }

        for(int i = 1; i < 10; i++) {
            countLessThan[i] += countLessThan[i - 1];
        }

        Edge[] sortedEdges = new Edge[edgesToSort.size()];

        for(int i = edgesToSort.size() - 1; i >= 0; i--) {
            int digitValue = getDigit(edgesToSort.get(i).getValue(), digitPos);

            sortedEdges[countLessThan[digitValue]-1] = edgesToSort.get(i);
            countLessThan[digitValue]--;
        }

        List<Edge<Integer>> sortedList = new ArrayList<Edge<Integer>>();
        for (Edge<Integer> edge : sortedEdges)
            sortedList.add(edge);

        return sortedList;
    }


    private static int getDigit(int value, int digitPos) {
        int digit = value;

        while(digitPos-- > 1) {
            digit /= 10;
        }

        return digit%10;
    }


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
