package edu.ufmg.dcc849.graph;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vinicius on 04/06/2016.
 */
public class CompleteGraphGenerator {
    private Integer verticeNum;
    private Integer maxWeight;
    private Integer caseNum;

    public CompleteGraphGenerator(Integer verticeNum, Integer maxWeight, Integer caseNum) {
        this.verticeNum = verticeNum;
        this.maxWeight = maxWeight;
        this.caseNum = caseNum;
    }

    /**
     * Creates a Complete Graph with normal distribution of weights
     * with a maximum value informed by the user
     *
     * Case Numbers (according to Kruskal's algorithm):
     * 1 - Average (Kruskal may obtain the MST at any point of the list of edges)
     * 2 - Worst: One vertex connected with maximum weight (this.maxWeight), forcing Kruskal to analyze every edge
     * 3 - Best: One vertex connected with minimum weight (0)
     */
    public Graph run() throws IOException {
        Graph newGraph = new Graph();

        for(Integer i = 0; i < this.verticeNum; i++){
            newGraph.addVertice(new Vertice(i.toString()));
        }

        for(Integer j = 1; j < this.verticeNum; j++){
            Vertice from = (Vertice) newGraph.getVertices().get(0);
            Vertice to = (Vertice) newGraph.getVertices().get(j);

            Edge newEdge = null;

            if(this.caseNum == 1)
                newEdge = new Edge<Integer>(from, to, (int) (Math.random()*this.maxWeight));
            else if(this.caseNum == 2)
                newEdge = new Edge<Integer>(from, to, this.maxWeight);
            else if(this.caseNum == 3)
                newEdge = new Edge<Integer>(from, to, 0);
            else{
                IOException e = new IOException();
                throw e;
            }

            newGraph.addEdge(newEdge);
        }

        for(Integer i = 1; i < this.verticeNum; i++){
            for(Integer j = i+1; j < this.verticeNum; j++){
                Vertice from = (Vertice) newGraph.getVertices().get(i);
                Vertice to = (Vertice) newGraph.getVertices().get(j);

                Edge newEdge = new Edge<Integer>(from, to, (int) (Math.random()*this.maxWeight));

                newGraph.addEdge(newEdge);
            }
        }

        return newGraph;
    }
}
