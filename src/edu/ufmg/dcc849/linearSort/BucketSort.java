package edu.ufmg.dcc849.linearSort;

import edu.ufmg.dcc849.graph.Edge;

import edu.ufmg.dcc849.comparedSort.*;

import java.util.LinkedList;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class BucketSort {
    public Edge[] runSort(Edge[] edgesToSort) {
        int maxValue = Integer.MIN_VALUE;

        for(Edge edge: edgesToSort)
            if (maxValue < (int)edge.getValue()) maxValue = (int)edge.getValue();

        int bucketNum = maxValue/5;

        LinkedList<Edge>[] bucketSet = new LinkedList[bucketNum];

        for(int i = 0; i < bucketNum; i++)
            bucketSet[i] = new LinkedList<Edge>();

        for (Edge edge : edgesToSort) {
            int j = bucketNum - 1;

            while (true) {
                if (j < 0)
                    break;

                if ((int)edge.getValue() >= (j * 5)) {
                    bucketSet[j].add(edge);
                    break;
                }
                j--;
            }
        }

        int index = 0;
        Edge[] sortedEdges = new Edge[edgesToSort.length];

        for(int i = 0; i < bucketNum; i++) {
            if(bucketSet[i].size() > 0) {
                Edge[] currBucket = new Edge[bucketSet[i].size()];

                for(int j = 0; j < currBucket.length; j++)
                    currBucket[j] = bucketSet[i].get(j);

                new InsertionSort().runSort(currBucket);

                for(int j = 0; j < currBucket.length; j++, index++)
                    sortedEdges[index] = currBucket[j];
            }
        }
        return sortedEdges;
    }
}
