package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */
public class Paths{

    public boolean hasPathFromto(DiGraph g, int u, int v){

        boolean[] visited = g.depthFirstSearch(u);
        return visited[v];

    }

    public boolean isMotherVertex(DiGraph g, int s){
        boolean[] visited = g.depthFirstSearch(s);
        for(int i=0; i<visited.length; i++){
            if(i!=s &&  !visited[i]){
                return false;
            }
        }
        return true;
    }
}
