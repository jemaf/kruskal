package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.InsertionSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vinicius on 22/06/2016.
 */
public class ModifiedBucketSort implements Sort<Edge<Integer>> {


    @Override
    public List<Edge<Integer>> sort(List<Edge<Integer>> unsortedList) {

        Edge<Integer> maxValue = unsortedList.get(0);

        for(Edge<Integer> value: unsortedList)
            if (maxValue.compareTo(value) < 0)
                maxValue = value;

        int bucketNum = unsortedList.size();
        int bucketInterval = (int) Math.ceil((double)(maxValue.getValue()+1)/(double)bucketNum);

        LinkedList<Edge<Integer>>[] bucketSet = new LinkedList[bucketNum];

        for(int i = 0; i < bucketNum; i++)
            bucketSet[i] = new LinkedList<Edge<Integer>>();

        for (Edge<Integer> value : unsortedList)
            bucketSet[value.getValue()/bucketInterval].add(value);

        /*System.out.println("Buckets to Sort:");

        for(LinkedList<Edge<Integer>> currBucket : bucketSet){
            System.out.print("A Bucket: ");
            for(Edge<Integer> currEdge: currBucket){
                System.out.print(currEdge.getValue() + " - ");
            }
            System.out.println();
        }*/

        int index = 0;
        ArrayList<Edge<Integer>> sortedList = new ArrayList<Edge<Integer>>();

        for(int i = 0; i < bucketNum; i++) {
            if(bucketSet[i].size() > 0) {
                List<Edge<Integer>> currBucket = (new InsertionSort()).sort(bucketSet[i]);

                //System.out.println("Sorted Bucket " + i + ":");
                for(int j = 0; j < currBucket.size(); j++, index++) {
                    //System.out.print(currBucket.get(j).getValue() + " - ");*/
                    sortedList.add(currBucket.get(j));
                }
                //System.out.println();
            }
        }

        /*System.out.println("Sorted values inside class with size " + sortedList.size() + ":");

        for(Edge<Integer> currEdge: sortedList){
            System.out.print(currEdge.getValue() + " - ");
        }
        System.out.println();*/

        return sortedList;
    }
}
