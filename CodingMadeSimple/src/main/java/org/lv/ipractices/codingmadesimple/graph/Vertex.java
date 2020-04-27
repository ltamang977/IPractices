package org.lv.ipractices.codingmadesimple.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    public int id;
    public T data;
    public List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();

    public Vertex(int id){
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<T> v){
        //edges.add(e);
        adjacentVertex.add(v);
    }

    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }

    public String toString(){
        return String.valueOf(id);
    }
}
