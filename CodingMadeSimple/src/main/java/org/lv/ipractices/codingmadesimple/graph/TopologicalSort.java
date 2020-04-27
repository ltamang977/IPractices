package org.lv.ipractices.codingmadesimple.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort<T> {


    public void topologicalSort(Graph<T> g){

        //depth first searc
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visitedSet = new HashSet<>();

        for (Vertex<T> verteV : g.allVertices) {
            if(!(visitedSet.contains(verteV))) {
                topologicalSortDfs(stack, visitedSet , g, verteV);
            }
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    public void topologicalSortDfs(Stack<Vertex<T>> stack, Set<Vertex<T>> visitedSet, Graph g, Vertex<T> vertex){

        visitedSet.add(vertex);
        for(Vertex<T> verteW: vertex.getAdjacentVertexes()){
            if(!(visitedSet.contains(verteW))) {
                topologicalSortDfs(stack, visitedSet , g, verteW);
            }

        }
        stack.push(vertex);
    }


}
