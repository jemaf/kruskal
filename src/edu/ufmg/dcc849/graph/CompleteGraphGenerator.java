package edu.ufmg.dcc849.graph;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vinicius on 04/06/2016.
 */
public class CompleteGraphGenerator {
    private Integer vertexNum;
    private Integer maxWeight;
    private Integer caseNum;

    public CompleteGraphGenerator(Integer verticeNum, Integer maxWeight, Integer caseNum) {
        this.vertexNum = verticeNum;
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

        for(Integer i = 0; i < vertexNum; i++){
            newGraph.addVertice(new Vertice(i.toString()));
        }

        for(Integer j = 1; j < vertexNum; j++){
            Vertice from = (Vertice) newGraph.getVertices().get(0);
            Vertice to = (Vertice) newGraph.getVertices().get(j);

            Edge newEdge = null;

            if(caseNum == 1)
                newEdge = new Edge<Integer>(from, to, (int) (Math.random()*maxWeight));
            else if(caseNum == 2)
                newEdge = new Edge<Integer>(from, to, maxWeight);
            else if(caseNum == 3)
                newEdge = new Edge<Integer>(from, to, 0);
            else{
                IOException e = new IOException();
                throw e;
            }

            newGraph.addEdge(newEdge);
        }

        for(Integer i = 1; i < vertexNum; i++){
            for(Integer j = i+1; j < vertexNum; j++){
                Vertice from = (Vertice) newGraph.getVertices().get(i);
                Vertice to = (Vertice) newGraph.getVertices().get(j);

                Edge newEdge = new Edge<Integer>(from, to, (int) (Math.random()*maxWeight));

                newGraph.addEdge(newEdge);
            }
        }

        return newGraph;
    }

    public Graph rewriteEdges(Graph graph){
        List<Edge<Integer>> edgeList = graph.getEdges();
        Integer edgesNum = edgeList.size();

        Graph newGraph = graph;

        /*
         * Rewriting first n-1 special edges, according to the selected case
         */
        for(Integer i = 0; i < (vertexNum - 1); i++){
            Edge currEdge = edgeList.get(i);
            if(caseNum == 1)
                currEdge.setValue((int) (Math.random()*maxWeight));
            else if(caseNum == 2)
                currEdge.setValue(maxWeight);
            else if(caseNum == 3)
                currEdge.setValue(0);

            newGraph.setEdge(i,currEdge);
        }

        for (Integer i = (vertexNum - 1); i < edgesNum; i++){
            Edge currEdge = edgeList.get(i);
            currEdge.setValue((int) (Math.random()*maxWeight));

            newGraph.setEdge(i,currEdge);
        }

        return newGraph;
    }
}
