package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */
public class DetectCycleInUnDirectedGraph {

    //using dfs
    public boolean hasCycle(Graph g){

        int vertexSize = g.getVertex();
        boolean visited[] = new boolean[vertexSize];

        for(int i=0;i<vertexSize; i++){
            if(!hasVisited(i, visited)){
                boolean flag = dfs(g, i, -1, visited);
                if(flag)
                    return true;
            }
        }
        return false;
    }

    public boolean hasVisited(int vertex, boolean[] visited){
        return visited[vertex];
    }

    public boolean dfs(Graph g, int vertex, int parent, boolean[] visited){
        visited[vertex]=true;

        for(int adj : g.adj(vertex)){

            if(adj==parent){
                continue;
            }

            if(hasVisited(adj, visited)){
                return true;
            }

            boolean hasCycle = dfs(g, adj, vertex, visited);
            if(hasCycle)
                return true;


        }

        return false;

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

        DetectCycleInUnDirectedGraph detectCycle = new DetectCycleInUnDirectedGraph();
        Graph unDirectedGraph = loadGraph();

        System.out.println("Check if graph has cycle :"+detectCycle.hasCycle(unDirectedGraph));
    }
}
