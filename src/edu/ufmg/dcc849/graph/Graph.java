package edu.ufmg.dcc849.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 6/2/16.
 */
public class Graph<T extends Comparable<T>> {

    private List<Edge<T>> edges;
    private List<Vertice> vertices;


    public Graph() {
        this.vertices = new ArrayList<Vertice>();
        this.edges = new ArrayList<Edge<T>>();
    }

    public void addEdge(Edge<T> edge) {
        this.edges.add(edge);
    }

    public void addVertice(Vertice vertice) {
        this.vertices.add(vertice);
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void setEdge(Integer index, Edge<T> edge){
        edges.set(index, edge);
    }

    public List<Vertice> getVertices() {
        return vertices;
    }
}
