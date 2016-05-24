package edu.ufmg.dcc849.sort.comparison;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> unsortedList) {
        List<T> sortedList = new ArrayList<T>();
        sortedList.addAll(unsortedList);

        sortInterval(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    private void sortInterval(List<T> list, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotPos = split(list, startIndex, endIndex);
            sortInterval(list, startIndex, pivotPos - 1);
            sortInterval(list, pivotPos + 1, endIndex);
        }
    }

    private int split(List<T> list, int startIndex, int endIndex) {
        T pivot = list.get(startIndex);
        int start = startIndex + 1;
        int end = endIndex;

        while (start <= end) {
            if (list.get(start).compareTo(pivot) <= 0)
                start++;
            else if (pivot.compareTo(list.get(end)) < 0)
                end--;
            else {
                T aux = list.get(start);

                list.add(start, list.get(end));
                list.remove(start + 1);

                list.add(end, aux);
                list.remove(end + 1);

                start++;
                end--;
            }
        }

        list.add(startIndex, list.get(end));
        list.remove(startIndex + 1);

        list.add(end, pivot);
        list.remove(end + 1);

        return end;
    }
}
