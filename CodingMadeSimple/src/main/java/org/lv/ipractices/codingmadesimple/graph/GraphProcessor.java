package org.lv.ipractices.codingmadesimple.graph;

public class GraphProcessor<T> {


    public Graph<Integer> loadGraph(){

        //13 nodes 0 through 12
        Graph<Integer> g = new Graph(true);
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

    public void printGraph(Graph<T> g){
        //Graph g = loadGraph();
        for(Vertex<T> v : g.allVertices){
            System.out.println("Vertex : "+v.id);
            for(Vertex<T> a : v.getAdjacentVertexes()){
                System.out.println("\t Adj :"+((Vertex)a).id);
            }
        }
    }



    public static void main(String[] args){

        GraphProcessor<Integer> gp = new GraphProcessor<>();
        Graph<Integer> g = gp.loadGraph();
        gp.printGraph(g);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.topologicalSort(g);

    }
}
