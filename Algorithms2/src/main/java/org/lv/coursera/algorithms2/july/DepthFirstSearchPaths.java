package org.lv.coursera.algorithms2.july;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchPaths {

    Graph g;
    int s;
    boolean[] visited;
    int[] edgeTo;

    public DepthFirstSearchPaths(Graph g, int s){
        this.g = g;
        this.s = s;
        this.visited = new boolean[g.vertex()];
        this.edgeTo = new int[g.vertex()];
        /*for(int i=0; i<g.vertex(); i++){
            edgeTo[i]=-1;
        }*/
        dfs(s);
    }


    public void dfs(int u){

        visited[u]=true;

        for(int v : g.adjacents(u)){
            if(!visited[v]){
                dfs(v);
                edgeTo[v]=u;
            }

        }

    }

    public boolean hasPathTo(int v){
        return visited[v];
    }


    public Iterable<Integer> pathTo(int v){

        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> path = new Stack<>();
        while(edgeTo[v]!=s){
            path.add(edgeTo[v]);
            v=edgeTo[v];
        }
        path.add(s);

        return path;
    }

    public static Graph loadGraph(){

        //13 nodes 0 through 12
        Graph g = new Graph(13);
        g.addEdge(0,5);
        g.addEdge(4,3);
        g.addEdge(0,1);
        g.addEdge(9,12);
        g.addEdge(6,4);
        g.addEdge(5,4);
        g.addEdge(0,2);
        g.addEdge(11,12);
        g.addEdge(9,10);
        g.addEdge(0,6);
        g.addEdge(7,8);
        g.addEdge(9,11);
        g.addEdge(5,3);
        return g;
    }


    public static void main(String[] args){

        Graph graph = loadGraph();
        DepthFirstSearchPaths dfsPaths = new DepthFirstSearchPaths(graph, 0);
        Iterable<Integer> list = dfsPaths.pathTo(3);

        System.out.println(list);


    }


}
