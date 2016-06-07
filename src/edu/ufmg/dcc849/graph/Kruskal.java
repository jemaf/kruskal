package edu.ufmg.dcc849.graph;

import edu.ufmg.dcc849.set.DisjointTreeSet;
import edu.ufmg.dcc849.sort.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edumontandon on 5/23/16.
 */
public class Kruskal<T extends Comparable<T>> {

    private Sort<Edge<T>> sortAlgorithm;

    public Kruskal(Sort<Edge<T>> sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }


    public List<Edge<T>> execute(Graph<T> graph) {

        List<Vertice> vertices = graph.getVertices();
        List<Edge<T>> edges = graph.getEdges();

        DisjointTreeSet<Vertice> verticesSet = setDisjointSet(vertices);
        List<Edge<T>> sortedEdges = sort(edges);

        List<Edge<T>> kruskalEdges = new ArrayList<Edge<T>>();
        int count = 0;

        while (count < vertices.size() - 1 && !sortedEdges.isEmpty()) {
            Edge<T> edge = sortedEdges.get(0);
            sortedEdges.remove(0);

            if (verticesSet.union(edge.getOrigin(), edge.getDestiny())) {
                kruskalEdges.add(edge);
                count++;
            }
        }
        return kruskalEdges;
    }


    private List<Edge<T>> sort(List<Edge<T>> edges) {
        return this.sortAlgorithm.sort(edges);
    }


    private DisjointTreeSet<Vertice> setDisjointSet(List<Vertice> vertices) {
        DisjointTreeSet<Vertice> f = new DisjointTreeSet<Vertice>();
        f.makeSet(vertices);

        return f;
    }
}
