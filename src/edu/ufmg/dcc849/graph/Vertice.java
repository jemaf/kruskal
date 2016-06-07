package edu.ufmg.dcc849.graph;

/**
 * Created by edumontandon on 5/20/16.
 */
public class Vertice {

    private String name;

    public Vertice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Check if two vertices are equals. Vertices are equals if they have same name
     *
     * @param obj The vertice to be compared
     *
     * @return true if equals, false otherwise
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Vertice))
            return false;

        return this.name.equals(((Vertice) obj).getName());
    }
}
