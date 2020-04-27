package org.lv.ipractices.leetcode.tree;



public class TreeNode{

    public int key;
    public int value;
    public  TreeNode left;
    public  TreeNode right;

    public TreeNode(int key, int value){
        this.key = key;
        this.value = value;
        left = right = null;
    }

    public TreeNode insert(int key, int value){
        return insert(this, key, value);
    }

    public TreeNode insert(TreeNode node, int key, int value){

        if(node == null)
            return new TreeNode(key, value);

        if(key==node.key){
            node.value = value;

        }else if (key<node.key){
            node.left = insert(node.left, key, value);

        }else if (key>node.key){
            node.right = insert(node.right, key, value);
        }

        return node;

    }


    public void inOrderTraversal(TreeNode root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.println("\t"+root.key);
        inOrderTraversal(root.right);

    }



}

