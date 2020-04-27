package org.lv.coursera.algorithms2.week1;


import java.util.Stack;

/**
 * Created by root on 12/2/17.
 */
public class TopologicalSortWithDepthFirstSearch {

    boolean[] marked;
    Stack<Integer> stack;


    public TopologicalSortWithDepthFirstSearch(DiGraph g, int v){
        marked = new boolean[g.getVertex()];
        stack = new Stack<Integer>();
    }


    public void topologicalSortWithDfs(DiGraph diGraph){
        for(int i=0; i<diGraph.getVertex();i++){
            if(!marked[i]){
                dfs(diGraph, i);
            }
        }
    }

    public void dfs(DiGraph diGraph, int v){
        marked[v]=true;
        for(int w : diGraph.adj(v)){
            if(!marked[w]){
                dfs(diGraph,w);
            }
        }
        stack.push(v);
    }


    //constraignt
    // directed graph
    //marked
    //recursive

}
