package org.lv.ipractices.codingmadesimple.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    public List<Vertex<T>> allVertices;
    public Map<Integer,Vertex<T>> map;
    boolean isDirected = false;


    public Graph(boolean isDirected){
        allVertices  = new ArrayList<Vertex<T>>();
        map  = new HashMap<>();
        this.isDirected = isDirected;
    }


    public void addEdge(int u, int v){
        if(!map.containsKey(u)){
            Vertex<T> vertexU = new Vertex<>(u);
            map.put(u, vertexU);
            allVertices.add(vertexU);
        }
        Vertex vertexU = map.get(u);

        if(!map.containsKey(v)){
            Vertex<T> vertexV = new Vertex<>(v);
            map.put(v, vertexV);
            allVertices.add(vertexV);
        }
        Vertex vertexV = map.get(v);

        vertexU.addAdjacentVertex(vertexV);

    }

    public List<Vertex<T>> getVertices(){
        return allVertices;
    }


}
