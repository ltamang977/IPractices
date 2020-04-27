package org.lv.ipractices.codingmadesimple.refgraph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    public int id;
    public T data;
    public List<Vertex<T>> adjacentVertex = new ArrayList<Vertex<T>>();

    public Vertex(int id){
        this.id = id;
    }


    /*public void addAdjacentVertex(Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
*/
}
