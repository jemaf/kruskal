package edu.ufmg.dcc849.sort;

import java.util.List;

/**
 * Created by edumontandon on 5/23/16.
 */
public interface Sort<T extends Comparable<T>> {

    List<T> sort(List<T> unsortedList);

}
