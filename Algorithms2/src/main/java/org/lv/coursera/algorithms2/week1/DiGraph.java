package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class DiGraph {

    private int v;//number of vertices0 to v
    private ArrayList<Integer> adj[]; //

    public DiGraph(int v){
        this.v = v;
        adj = (ArrayList<Integer>[]) new ArrayList[v];
        for(int i=0;i<v; i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getVertex(){
        return v;
    }

    public boolean[] depthFirstSearch(int s){
        boolean[] visited = new boolean[v];
        depthFirstSearch(s, visited);
        return visited;
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


    public boolean detectCycle(int s){
        boolean[] visited = new boolean[v];
        int[] edgeTo = new int[v];
        edgeTo[s]=-1;

        return detectCycle(s,visited, edgeTo);

    }

    public boolean detectCycle(int u, boolean[] visited, int[] edgeTo){
        System.out.println("Visiting"+u);
        visited[u]=true;

        for(int v :adj(u)){

            if(isCyclic(u, v,edgeTo))
                return true;//cycle detected

           if(!visited[v]){

               edgeTo[v]= u;
                boolean isCycle  = detectCycle(v, visited, edgeTo);
                if(isCycle)
                    return true;
            }

        }
        return false;
    }

    boolean isCyclic(int u, int v, int[] edgeTo){
        if(u==v)
            return true;

        int from = edgeTo[u];
        while(from != -1){
            if(from==v)
                return true;
            from = edgeTo[from];
        }
        return false;

    }


}
