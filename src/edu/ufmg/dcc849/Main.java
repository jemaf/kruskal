package edu.ufmg.dcc849;

import edu.ufmg.dcc849.graph.*;
import edu.ufmg.dcc849.sort.Sort;
import edu.ufmg.dcc849.sort.comparison.QuickSort;
import edu.ufmg.dcc849.sort.linear.BucketSort;
import edu.ufmg.dcc849.sort.linear.CountingSort;
import edu.ufmg.dcc849.util.*;

import java.io.IOException;

/**
 * Created by edumontandon on 5/10/16.
 */
public class Main {

    public static void main(String args[]) throws IOException {
        Integer maxVertexNum = Integer.parseInt(args[0]);
        Integer caseNum = Integer.parseInt(args[1]);
        Integer maxRunTime = Integer.parseInt(args[2]);
        Double tValue = Double.parseDouble(args[3]);

        //Execution time for each run and each algorithm
        Double[] execTimeCounting = new Double[maxRunTime];
        Double[] execTimeQuick = new Double[maxRunTime];
        Double[] execTimeBucket = new Double[maxRunTime];

        Sort<Edge<Integer>> countingSort = new CountingSort();
        Sort<Edge<Integer>> bucketSort = new BucketSort();
        Sort<Edge<Integer>> quickSort = new QuickSort();

        Kruskal<Integer> kruskalCounting = new Kruskal<Integer>(countingSort);
        Kruskal<Integer> kruskalBucket = new Kruskal<Integer>(bucketSort);
        Kruskal<Integer> kruskalQuick = new Kruskal<Integer>(quickSort);

        Long startTime, endTime; //Start and end timestamp for a single run

        System.out.println("Vertex_Num\tAvg_Couting\tIC_Counting\tAvg_Bucket\tIC_Bucket\tAvg_Quick\tIC_Quick");

        for(Integer currVertexNum = 10; currVertexNum <= maxVertexNum; currVertexNum += 10){ //Varies the number of vertices
            /*
             * Execute the algorithms for different instances of graphs with the same settings
             */
            for(Integer currRunTime = 0; currRunTime < maxRunTime; currRunTime++) {
                CompleteGraphGenerator currGen = new CompleteGraphGenerator(currVertexNum,
                        2 * currVertexNum, caseNum);
                Graph currGraphInstance = currGen.run();

                startTime = System.currentTimeMillis();
                kruskalCounting.execute(currGraphInstance);
                endTime = System.currentTimeMillis();
                execTimeCounting[currRunTime] = Double.valueOf(endTime - startTime);

                startTime = System.currentTimeMillis();
                kruskalBucket.execute(currGraphInstance);
                endTime = System.currentTimeMillis();
                execTimeBucket[currRunTime] = Double.valueOf(endTime - startTime);

                startTime = System.currentTimeMillis();
                kruskalQuick.execute(currGraphInstance);
                endTime = System.currentTimeMillis();
                execTimeQuick[currRunTime] = Double.valueOf(endTime - startTime);
            }

            Statistics countingStats = new Statistics(execTimeCounting);
            Statistics bucketStats = new Statistics(execTimeBucket);
            Statistics quickStats = new Statistics(execTimeQuick);

            String result = currVertexNum + "\t" +
                    countingStats.getMean() + "\t" + countingStats.getConfidenceInterval(tValue) + "\t" +
                    bucketStats.getMean() + "\t" + bucketStats.getConfidenceInterval(tValue) + "\t" +
                    quickStats.getMean() + "\t" + quickStats.getConfidenceInterval(tValue);

            System.out.println(result);
        }
    }
}
