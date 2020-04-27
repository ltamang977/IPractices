package org.lv.ipractices.ctci._4_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectGraph<T> {

    List<Project<T>> allProjects = new ArrayList<>();
    Map<T,Project<T>> map = new HashMap<>();


    public void addEdge(T first, T second){
        if(!map.containsKey(first)){
            Project firstProject = new Project(first);
            allProjects.add(firstProject);
            map.put(first, firstProject);
        }
        Project firstP = map.get(first);

        if(!map.containsKey(second)){
            Project secondProject = new Project(second);
            allProjects.add(secondProject);
            map.put(second, secondProject);
        }
        Project secondP = map.get(second);

        firstP.addAdjacent(secondP);

    }
}
