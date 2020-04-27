package org.lv.coursera.algorithms2.week1;


//June 29
public class GraphClient {

    public void dfs(Graph g){

    }


    public static int degree(Graph graph, int v){

        int count = 0;
        for(Integer ad : graph.adj(v)){
            count++;
        }
        return count;

    }


    public static int maxDegree(Graph graph){

        int maxCount = 0;
        for(int i = 0; i<graph.getVertex(); i++){
            int count = 0;
            if(degree(graph, i)>maxCount){
                maxCount = degree(graph, i);
            }
        }

        return maxCount;

    }


    public static int selfLoops(Graph graph){

        int adjCount = 0;
        for(int i = 0; i<graph.getVertex(); i++){
            for(int a : graph.adj(i)){
                if(i==a){
                    adjCount++;
                }
            }
        }
        return adjCount;

    }
}
