package edu.ufmg.dcc849.set;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by edumontandon on 5/11/16.
 */
public class DisjointTreeSet<T> {

    private class Node<T> {
        Node<T> parent;

        int rank;

        T value;

        public Node(Node<T> parent, T value, int rank) {
            this.parent = parent;
            this.rank = rank;
            this.value = value;
        }
    }



    private Map<T, Node<T>> set;


    public DisjointTreeSet() {
        this.set = new HashMap<T, Node<T>>();
    }


    public void makeSet(T value) {
        Node<T> newNode = new Node<T>(null, value, 0);
        this.set.put(value, newNode);
    }


    public void makeSet(List<T> values) {
        for (T value : values)
            this.makeSet(value);
    }


    public T findSet(T value) {
        Node<T> node = this.set.get(value);

        if (node == null)
            return null;

        if (node.parent == null)
            return node.value;
        else
            return findSet(node.parent.value);
    }


    public boolean union(T v1, T v2) {

        T v1Root = this.findSet(v1);
        T v2Root = this.findSet(v2);

        if (v1Root != null && v2Root!= null && !v1Root.equals(v2Root)) {
            Node<T> nodeV1 = this.set.get(v1Root);
            Node<T> nodeV2 = this.set.get(v2Root);

            if (nodeV1.rank >= nodeV2.rank) {
                nodeV2.parent = nodeV1;

                if (nodeV1.rank == nodeV2.rank)
                    nodeV1.rank++;
            } else {
                nodeV1.parent = nodeV2;
            }

            return true;
        }

        return false;
    }

}
