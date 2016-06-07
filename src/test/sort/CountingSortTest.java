package test.sort;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.linear.CountingSort;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by edumontandon on 5/31/16.
 */
public class CountingSortTest extends LinearSortTest {

    @Test
    public void testSort() throws Exception {
        sortingAlgorithm = new CountingSort();

        List<Edge<Integer>> testingList = sortingAlgorithm.sort(unsortedList);
        assertArrayEquals(sortedList.toArray(), testingList.toArray());
    }
}