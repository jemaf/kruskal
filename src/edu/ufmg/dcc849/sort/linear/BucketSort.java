package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.InsertionSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class BucketSort implements Sort<Edge<Integer>> {


    @Override
    public List<Edge<Integer>> sort(List<Edge<Integer>> unsortedList) {

        Edge<Integer> maxValue = unsortedList.get(0);

        for(Edge<Integer> value: unsortedList)
            if (maxValue.compareTo(value) < 0)
                maxValue = value;

        int bucketNum = maxValue.getValue()/5;

        LinkedList<Edge<Integer>>[] bucketSet = new LinkedList[bucketNum];

        for(int i = 0; i < bucketNum; i++)
            bucketSet[i] = new LinkedList<Edge<Integer>>();

        for (Edge<Integer> value : unsortedList) {
            int j = bucketNum - 1;

            while (true) {
                if (j < 0)
                    break;

                if (value.getValue() >= (j * 5)) {
                    bucketSet[j].add(value);
                    break;
                }
                j--;
            }
        }

        int index = 0;
        List<Edge<Integer>> sortedList = new ArrayList<Edge<Integer>>();

        for(int i = 0; i < bucketNum; i++) {
            if(bucketSet[i].size() > 0) {
                List<Edge<Integer>> currBucket = (new InsertionSort()).sort(bucketSet[i]);

                for(int j = 0; j < currBucket.size(); j++, index++)
                    sortedList.add(currBucket.get(j));
            }
        }
        return sortedList;
    }
}
