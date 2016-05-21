package edu.ufmg.dcc849.graph;

/**
 * Created by edumontandon on 5/20/16.
 */
public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {

    private Vertice origin;

    private Vertice destiny;

    T value;

    public Edge(Vertice origin, Vertice destiny, T value) {
        this.origin = origin;
        this.destiny = destiny;
        this.value = value;
    }


    /**
     * Check which edge is "bigger". In this case, check which one has greater value.
     *
     * @param edge The edge to be compared
     *
     * @return 1 if this > edge, 0 if equals, -1 otherwise
     */
    @Override
    public int compareTo(Edge<T> edge) {
        return this.value.compareTo(edge.value);
    }

    public Vertice getOrigin() {
        return origin;
    }

    public void setOrigin(Vertice origin) {
        this.origin = origin;
    }

    public Vertice getDestiny() {
        return destiny;
    }

    public void setDestiny(Vertice destiny) {
        this.destiny = destiny;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
