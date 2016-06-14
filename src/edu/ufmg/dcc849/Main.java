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
        Integer startVertexNum = Integer.parseInt(args[0]);
        Integer endVertexNum = Integer.parseInt(args[1]);
        Integer caseNum = Integer.parseInt(args[2]);
        Integer maxRunTime = Integer.parseInt(args[3]);
        Double tValue = Double.parseDouble(args[4]);

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

        for(Integer currVertexNum = startVertexNum; currVertexNum <= endVertexNum; currVertexNum += (currVertexNum*10)/100){ //Varies the number of vertices
            /*
             * Execute the algorithms for different instances of graphs with the same settings
             */
            CompleteGraphGenerator currGen = new CompleteGraphGenerator(currVertexNum,
                    2 * currVertexNum, caseNum);
            Graph currGraphInstance = currGen.run();

            for(Integer currRunTime = 0; currRunTime < maxRunTime; currRunTime++) {
                if(currRunTime > 0)
                    currGraphInstance = currGen.rewriteEdges(currGraphInstance);

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
