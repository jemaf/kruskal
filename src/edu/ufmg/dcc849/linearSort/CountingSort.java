package edu.ufmg.dcc849.linearSort;

import edu.ufmg.dcc849.graph.Edge;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class CountingSort {
    public Edge[] runSort(Edge[] edgesToSort) {
        int[] countLessThan = new int[findMaxValue(edgesToSort)+1];

        for(int i = 0; i < countLessThan.length; i++){
            countLessThan[i] = 0;
        }

        for (Edge edge : edgesToSort) {
            countLessThan[(int)edge.getValue()]++;
        }

        //Assuming that there are edges with zero weight
        for(int i = 1; i < countLessThan.length; i++) {
            countLessThan[i] = countLessThan[i] + countLessThan[i - 1];
        }

        Edge[] sortedEdges = new Edge[edgesToSort.length];

        for(int i = edgesToSort.length-1; i >= 0; i--) {
            sortedEdges[countLessThan[(int)edgesToSort[i].getValue()]-1] = edgesToSort[i];
            countLessThan[(int)edgesToSort[i].getValue()]--;
        }

        return sortedEdges;
    }

    public Edge[] runSortDigit(Edge[] edgesToSort, int digitPos) {
        int[] countLessThan = new int[10];

        for(int i = 0; i < 10; i++){
            countLessThan[i] = 0;
        }

        for (Edge edge : edgesToSort) {
            int digitValue = getDigit((int)edge.getValue(), digitPos);
            countLessThan[digitValue]++;
        }

        for(int i = 1; i < 10; i++) {
            countLessThan[i] += countLessThan[i - 1];
        }

        Edge[] sortedEdges = new Edge[edgesToSort.length];

        for(int i = edgesToSort.length-1; i >= 0; i--) {
            int digitValue = getDigit((int)edgesToSort[i].getValue(),digitPos);

            sortedEdges[countLessThan[digitValue]-1] = edgesToSort[i];
            countLessThan[digitValue]--;
        }

        return sortedEdges;
    }

    private static int getDigit(int value, int digitPos) {
        int digit = value;

        while(digitPos-- > 1) {
            digit /= 10;
        }

        return digit%10;
    }

    private static int findMaxValue(Edge[] edgeArray) {
        int maxValue = Integer.MIN_VALUE;

        for(Edge edge: edgeArray) {
            if((int)edge.getValue() > maxValue) {
                maxValue = (int)edge.getValue();
            }
        }

        return maxValue;
    }
}
