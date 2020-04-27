package org.lv.coursera.algorithms2.week1;

/**
 * Created by root on 1/15/18.
 */
public class DiGraphDemo {

    public static DiGraph loadGraph(){

        //13 nodes 0 through 12
        DiGraph g = new DiGraph(7);
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

    public static DiGraph loadCyclicGraph(){

        //13 nodes 0 through 12
        DiGraph g = new DiGraph(4);
        g.addEdge(0,1);
       // g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        return g;
    }

    public static void printGraph(DiGraph g){
        //Graph g = loadGraph();
        for(int i =0; i<g.getVertex();i++){
            System.out.println("Vertex : "+i);
            for(Integer adj : g.adj(i)){
                System.out.println("\t Adj :"+adj);
            }
        }
    }


    public static void main(String[] args){

       //DiGraph g = loadGraph();
       DiGraph g = loadCyclicGraph();
       printGraph(g);

       /*
       DepthFirstSearchPaths paths = new DepthFirstSearchPaths();
       for(int i =0 ; i<g.getVertex(); i++) {
           System.out.println("checking if mother vertex :"+i +" is " +paths.isMotherVertex(g, i));
       }
       */
      // g.depthFirstSearch(0);
       //g.breadthFirstSearch(0);

        //cycle detection in directed graph

        System.out.println("Checking if cycle is present "+g.detectCycle(2));



    }
}
