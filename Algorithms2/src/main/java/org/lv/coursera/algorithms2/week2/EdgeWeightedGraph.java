package org.lv.coursera.algorithms2.week2;

import java.io.InputStream;

/**
 * Created by root on 12/3/17.
 */
public class EdgeWeightedGraph {

    boolean[] marked;
    private Bag<Edge>[] bagArray;

    public EdgeWeightedGraph(int v){
        marked = new boolean[v];
        bagArray = (Bag<Edge>[]) new Bag[v];
        for(int i=0; i<v; i++){
            bagArray[v] = new Bag<Edge>();
         }
    }

    public EdgeWeightedGraph(InputStream in){

    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        bagArray[v].add(w);
        bagArray[w].add(v);

    }

    public Iterable<Edge> adjacents(int v){
        return null;
    }
}

