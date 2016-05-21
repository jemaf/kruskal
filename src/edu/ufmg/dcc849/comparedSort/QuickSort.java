package edu.ufmg.dcc849.comparedSort;

import edu.ufmg.dcc849.graph.Edge;

/**
 * Created by Vinicius on 21/05/2016.
 */
public class QuickSort {
    public static void runSortEdge(Edge[] edgesToSort)
    {
        runSortEdgeInterval(edgesToSort, 0, edgesToSort.length - 1);
    }

    private static void runSortEdgeInterval(Edge[] edgesToSort, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int pivotPos = splitByPivot(edgesToSort, startIndex, endIndex);
            runSortEdgeInterval(edgesToSort, startIndex, pivotPos - 1);
            runSortEdgeInterval(edgesToSort, pivotPos + 1, endIndex);
        }
    }

    private static int splitByPivot(Edge[] edgesToSort, int startIndex, int endIndex)
    {
        Edge pivot = edgesToSort[startIndex];
        int start = startIndex + 1;
        int end = endIndex;

        while (start <= end)
        {
            if (edgesToSort[start].compareTo(pivot) <= 0)
                start++;
            else if (pivot.compareTo(edgesToSort[end]) < 0)
                end--;
            else
            {
                Edge aux = edgesToSort[start];
                edgesToSort[start] = edgesToSort[end];
                edgesToSort[end] = aux;
                start++;
                end--;
            }
        }

        edgesToSort[startIndex] = edgesToSort[end];
        edgesToSort[end] = pivot;

        return end;
    }
}
