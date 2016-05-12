package edu.ufmg.dcc849;

import edu.ufmg.dcc849.set.DisjointTreeSet;

import java.util.ArrayList;

/**
 * Created by edumontandon on 5/10/16.
 */
public class Main {

    public static void main(String args[]) {

        DisjointTreeSet<Integer> disjointTreeSet = new DisjointTreeSet<Integer>();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        for (Integer number : arrayList) {
            disjointTreeSet.makeSet(number);
        }

        disjointTreeSet.union(1, 3);
        disjointTreeSet.union(4, 5);
        disjointTreeSet.union(1, 2);

        for (Integer number : arrayList) {
            Integer rootValue = disjointTreeSet.findSet(number);
            System.out.println("Value: " + number + "\t Root: " + rootValue);
        }
    }
}
