package org.lv.ipractices.codingmadesimple.refgraph;

import java.util.ArrayList;

public class Graph<T> {

    int v;//number of vertices
    ArrayList<Integer>[] adjacentVertices;


    public Graph(int v){
        this.v = v;

        adjacentVertices = (ArrayList<Integer>[])new ArrayList[v];
        for(int i=0; i<v; i++){
            adjacentVertices[i] = new ArrayList<Integer>();
        }
    }


    public void addEdge(int u, int v){
        adjacentVertices[u].add(v);
        //adjacentVertices[v].add(u);

    }

    public int getVertices(){
        return v;
    }

    public ArrayList<Integer> adj(int v){
        return adjacentVertices[v];
    }

}
