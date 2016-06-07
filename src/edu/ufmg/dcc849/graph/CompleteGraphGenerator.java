package edu.ufmg.dcc849.graph;

/**
 * Created by Vinicius on 04/06/2016.
 */
public class CompleteGraphGenerator {
    private Integer verticeNum;

    public CompleteGraphGenerator(Integer verticeNum) {
        this.verticeNum = verticeNum;
    }

    public Graph generateNormalDist (Integer maxWeight){
        Graph normalDistGraph = new Graph();

        for(Integer i = 0; i < this.verticeNum; i++){
            normalDistGraph.addVertice(new Vertice(i.toString()));
        }

        for(Integer i = 0; i < this.verticeNum; i++){
            for(Integer j = i+1; j < this.verticeNum; j++){
                Vertice from = (Vertice) normalDistGraph.getVertices().get(i);
                Vertice to = (Vertice) normalDistGraph.getVertices().get(j);
                Edge newEdge = new Edge<Integer>(from, to, (int) (Math.random()*maxWeight));

                normalDistGraph.addEdge(newEdge);
            }
        }
        return normalDistGraph;
    }
}
