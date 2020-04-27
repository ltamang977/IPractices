package org.lv.ipractices.ctci._4_Graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class BuildOrder<T> {


    public Deque buildOrder(ProjectGraph<T> graph){
        Deque deque = new ArrayDeque();
        Set visitedSet = new HashSet();
        for(Project<T> project : graph.allProjects){
            if(!visitedSet.contains(project)){
                doDfs(deque, visitedSet, project);
            }
        }

        return deque;

    }



    public void doDfs(Deque<Project<T>> deque, Set<Project<T>> visitedSet, Project<T> project){
        visitedSet.add(project);

        for(Project<T> adj : project.adjacentProjects){
            if(!visitedSet.contains(adj)){
                doDfs( deque,  visitedSet,  adj);
            }
        }
        deque.offerFirst(project);

    }




    public static void main(String[] args){
        //a,b,c,d,e,f
        //(a,b), (b,c)

        ProjectGraph<Integer> g = new ProjectGraph<>();
       /* graph.addEdge("a", "e");
        graph.addEdge("b", "a");
        graph.addEdge("b", "h");
        graph.addEdge("c", "a");
        graph.addEdge("d", "g");
        graph.addEdge("f", "a");
        graph.addEdge("f", "b");
        graph.addEdge("f", "c");*/

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(4,1);
        g.addEdge(6,4);
        g.addEdge(5,6);
        g.addEdge(5,2);
        g.addEdge(6,0);


        BuildOrder<Integer> buildOrder = new BuildOrder();
        Deque<Project<Integer>> deque = buildOrder.buildOrder(g);

        while(!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }
    }
}
