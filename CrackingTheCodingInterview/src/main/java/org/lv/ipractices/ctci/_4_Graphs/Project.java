package org.lv.ipractices.ctci._4_Graphs;

import java.util.ArrayList;
import java.util.List;

public class Project<T> {
    T name;//a,b,c,d,e
    List<Project> adjacentProjects= new ArrayList<>();

    public Project(T name){
        this.name = name;
    }

    public void addAdjacent(Project project){
        adjacentProjects.add(project);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
