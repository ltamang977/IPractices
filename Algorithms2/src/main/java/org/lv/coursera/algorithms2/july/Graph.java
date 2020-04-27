package org.lv.coursera.algorithms2.july;

import java.util.ArrayList;

public class Graph {

    final int v;//number of vertices
    ArrayList<Integer>[] adjs;

    public Graph(int v){
        this.v = v;
        this.adjs = (ArrayList<Integer>[]) new ArrayList[v];

        for(int i =0; i<v; i++){
            this.adjs[i]= new ArrayList<>();
        }
    }


    public void addEdge(int v, int w){
        adjs[v].add(w);
        adjs[w].add(v);
    }


    public Iterable<Integer> adjacents(int v){
        return adjs[v];
    }

    public int vertex(){
        return v;
    }

}
