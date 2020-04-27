package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */
public class GraphDemo {

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

    public static void printGraph(Graph g){
        //Graph g = loadGraph();
        for(int i =0; i<g.getVertex();i++){
            System.out.println("Vertex : "+i);
            for(Integer adj : g.adj(i)){
                System.out.println("\t Adj :"+adj);
            }
        }
    }


    public static void main(String[] args){

       Graph g = loadGraph();
       printGraph(g);

      // g.depthFirstSearch(0);
       g.breadthFirstSearch(0);

    }
}
