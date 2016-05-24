package edu.ufmg.dcc849.sort.linear;

import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
//
//    TODO fix this class
public class BucketSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public List<T> sort(List<T> unsortedList) {
        return null;
    }

//    @Override
//    public List<T> sort(List<T> unsortedList) {
//
//        T maxValue = unsortedList.get(0);
//
//        for(T value: unsortedList)
//            if (maxValue.compareTo(value) < 0)
//                maxValue = value;
//
//        int bucketNum = (Integer)maxValue/5;
//
//        LinkedList<T>[] bucketSet = new LinkedList[bucketNum];
//
//        for(int i = 0; i < bucketNum; i++)
//            bucketSet[i] = new LinkedList<T>();
//
//        for (T value : unsortedList) {
//            int j = bucketNum - 1;
//
//            while (true) {
//                if (j < 0)
//                    break;
//
//                if ((Integer)value >= (j * 5)) {
//                    bucketSet[j].add(value);
//                    break;
//                }
//                j--;
//            }
//        }
//
//        int index = 0;
//        List<T> sortedList = new ArrayList<T>();
//
//        for(int i = 0; i < bucketNum; i++) {
//            if(bucketSet[i].size() > 0) {
//                Edge[] currBucket = new Edge[bucketSet[i].size()];
//
//                for(int j = 0; j < currBucket.length; j++)
//                    currBucket[j] = bucketSet[i].get(j);
//
//                new InsertionSort().runSort(currBucket);
//
//                for(int j = 0; j < currBucket.length; j++, index++)
//                    sortedList[index] = currBucket[j];
//            }
//        }
//        return sortedList;
//    }
}
