package org.lv.ipractices.codingmadesimple.refgraph;

public class GraphProcessor {


    public static Graph loadGraph(){

        //13 nodes 0 through 12
        Graph g = new Graph(7);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(4,1);
        g.addEdge(6,4);
        g.addEdge(5,6);
        g.addEdge(5,2);
        g.addEdge(6,0);
        return g;
    }

    public static void printGraph(Graph g){
        //Graph g = loadGraph();
        for(int i =0; i<g.getVertices();i++){
            System.out.println("Vertex : "+i);
            for(Object a : g.adj(i)){
                System.out.println("\t Adj :"+a);
            }
        }
    }



    public static void main(String[] args){
        Graph g = loadGraph();
        printGraph(g);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(g);

    }
}
