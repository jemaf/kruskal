package test.sort;

import edu.ufmg.dcc849.graph.Edge;
import edu.ufmg.dcc849.sort.linear.BucketSort;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by edumontandon on 5/31/16.
 */
public class BucketSortTest extends LinearSortTest {

    @org.junit.Test
    public void testSort() throws Exception {
        sortingAlgorithm = new BucketSort();

        List<Edge<Integer>> testingList = sortingAlgorithm.sort(unsortedList);
        assertArrayEquals(sortedList.toArray(), testingList.toArray());
    }
}