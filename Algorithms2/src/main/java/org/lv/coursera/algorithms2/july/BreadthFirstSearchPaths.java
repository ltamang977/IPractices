package org.lv.coursera.algorithms2.july;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearchPaths {

    private boolean[] visited;
    private int[] edgeTo;
    Graph g;
    int s;

    public BreadthFirstSearchPaths(Graph g, int s){
        this.g = g;
        int v = g.vertex();
        visited = new boolean[v];
        edgeTo = new int[v];
        this.s = s;
        bfs(s);

    }

    public void bfs(int s){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s]=true;

        while(!queue.isEmpty()){

            int u = queue.poll();
            for(int v : g.adjacents(u)){
                if(!visited[v]) {
                    queue.offer((v));
                    visited[v]=true;
                    edgeTo[v]=u;
                }

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
        BreadthFirstSearchPaths bfsPaths = new BreadthFirstSearchPaths(graph, 0);
        Iterable<Integer> list = bfsPaths.pathTo(3);

        System.out.println(list);


    }
}
