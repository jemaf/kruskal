package test.sort;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.comparison.QuickSort;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by edumontandon on 5/31/16.
 */
public class QuickSortTest extends LinearSortTest {

    @org.junit.Test
    public void testSort() throws Exception {
        sortingAlgorithm = new QuickSort<Edge<Integer>>();

        List<Edge<Integer>> testingList = sortingAlgorithm.sort(unsortedList);
        assertArrayEquals(sortedList.toArray(), testingList.toArray());
    }
}