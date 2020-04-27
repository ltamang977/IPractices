package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */

import java.util.List;
import java.util.ArrayList;

import java.util.Queue;
import java.util.LinkedList;

public class Graph {

    private int v;//number of vertices0 to v
    private ArrayList<Integer> adj[]; //

    public Graph(int v){
        this.v = v;
        adj = (ArrayList<Integer>[]) new ArrayList[v];
        for(int i=0;i<v; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getVertex(){
        return v;
    }

    public void depthFirstSearch(int s){
        boolean[] visited = new boolean[v];
        depthFirstSearch(s, visited);

    }

    //
    public void depthFirstSearch(int s, boolean[] visited){
        visited[s]= true;
        System.out.println("Visited : "+s);
        for(Integer i : adj(s)){
            if(!visited[i]){
                depthFirstSearch(i, visited);
            }
        }

    }

    public void breadthFirstSearch(int s){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[v];

        visited[s]=true;
        queue.addLast(s);

        while(!queue.isEmpty()){
            int u = queue.removeFirst();

            System.out.println("Visited :"+u);

            for(Integer v : adj(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.addLast(v);
                }
            }
        }
    }
}
