package org.lv.ipractices.revisionaprend.cracking.treesandgraphs;

public class Graph {

    TreeNode[] nodes;

    private static class TreeNode{
        String name;
        TreeNode[] adjacents;

        public TreeNode(String name){
            this.name = name;
            this.adjacents=null;
        }

    }

    public Graph(int n){
        nodes = new TreeNode[n];
    }
}
