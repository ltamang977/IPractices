package org.lv.coursera.algorithms2.week2;

/**
 * Created by root on 12/3/17.
 */
public class Edge implements Comparable<Edge> {

    private int v;
    private int w;
    private int weight;

    public Edge(int v, int w, int weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if (vertex == v)
            return v;
        else
            return w;
    }

    public void add(int v){

    }

    @Override
    public int compareTo(Edge o) {
        if(weight < o.weight)
            return -1;
        else if (weight > o.weight)
            return 1;
        return 0;
    }
}
