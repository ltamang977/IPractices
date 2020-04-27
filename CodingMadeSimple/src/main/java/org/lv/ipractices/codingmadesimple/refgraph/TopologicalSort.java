package org.lv.ipractices.codingmadesimple.refgraph;

import java.util.Stack;

public class TopologicalSort {

    boolean[] visited;



    public void topologicalSort(Graph g){


        //depth first searc
        Stack<Integer> revershPush = new Stack<>();
        visited = new boolean[g.getVertices()];

        for(int u=0; u<g.getVertices(); u++){
            if(!visited[u]) {
                topologicalSortDfs(revershPush, g, u);
            }
        }

        while(!revershPush.empty()){
            System.out.println(revershPush.pop().intValue());
        }
    }

    public void topologicalSortDfs(Stack<Integer> stack, Graph g, int v){
        visited[v]=true;

        for(Object w : g.adj(v)){
            if(!visited[(Integer)w]){
                topologicalSortDfs(stack, g, (Integer)w);
            }

        }
        stack.push(v);
    }





}
