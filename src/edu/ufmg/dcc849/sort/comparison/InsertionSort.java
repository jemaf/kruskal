package edu.ufmg.dcc849.sort.comparison;

import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> unsortedList) {

        List<T> sortedList = new ArrayList<T>();
        sortedList.addAll(unsortedList);

        for(int i = 1; i < sortedList.size(); i++) {
            T currentElement = sortedList.get(i);

            int j = i - 1;

            while((j >= 0) && (currentElement.compareTo(sortedList.get(j)) < 0)) {
                sortedList.add(j + 1, sortedList.get(j));
                sortedList.remove(j);
                j--;
            }
            sortedList.remove(i);
            sortedList.add(j + 1, currentElement);
        }
        return sortedList;
    }
}