package org.lv.ipractices.revisionaprend.bytebybyte;

public class BinarySearchTree<K extends Comparable<K>,V> {

    TreeNode<K,V> root;

    static class TreeNode<K extends Comparable<K>,V>{

        K key;
        V value;
        TreeNode<K,V> left;
        TreeNode<K,V> right;

        public TreeNode(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }


    public TreeNode<K,V> root(){
        return root;
    }

    public void put(K key, V value){
        root = insert(root, key, value);
    }

    public TreeNode<K,V> insert(TreeNode<K,V> root, K key, V value){
        if(root==null)
            return new TreeNode<>(key, value);

        if(root.key==key){
            root.value = value;

        }else if (key.compareTo(root.key)<=0){
            root.left = insert(root.left, key, value);

        }else {
            root.right =  insert(root.right, key, value);

        }

        return root;
    }

/*    public void insertItr(K key, V value){

        TreeNode<K,V> curr = root;

        if(curr==null) {
            curr = new TreeNode<>(key, value);
            return;
        }

        while(curr!=null){
            if(curr.key==key){
                curr.value = value;

            }else if (key.compareTo(curr.key)<0){
                curr = curr.left;

            }else {
                curr = curr.right;

            }
        }

    }*/




    //search
    public V get(K key){

        TreeNode<K,V> curr = root;

        while(curr!=null){
            if(curr.key==key){
                return curr.value;

            }else if (key.compareTo(curr.key)<=0){
                curr = curr.left;

            }else {
                curr = curr.right;

            }
        }

        return null;

    }

    public void delete(K key){

    }



    public K min(TreeNode<K,V> node){

        if(node==null)
            return null;

        while(node.left!=null){
            node = node.left;
        }
        return node.key;
    }


    public K max(TreeNode<K,V> node){

        if(node==null)
            return null;

        while(node.right!=null){
            node = node.right;
        }
        return node.key;
    }


    public void preorder(TreeNode<K,V> root){

        if(root==null)
            return;

        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);

    }

    public void inorder(TreeNode<K,V> root){

        if(root==null)
            return;

        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);

    }

    public void postorder(TreeNode<K,V> root){

        if(root==null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.key);

    }


  /*  public boolean isBst(){

    }*/



    public boolean isBst(TreeNode<K,V> node){

        if(node==null){
            return true;
        }

        if(node.left!=null && node.key.compareTo(max(node.left))<0){
            return false;
        }

        if(node.right!=null && node.key.compareTo(min(node.right))>=0){
            return false;
        }

        return isBst(node.left)
                && isBst(node.right);

    }

    public boolean isBstRevised(TreeNode<K,V> node, K min, K max){


        if(node==null){
            return true;
        }

        if(node.key.compareTo(max)>0){
            return false;
        }

        if(node.key.compareTo(min)<=0){
            return false;
        }

        return isBstRevised(node.left, min, node.key) && isBstRevised(node.right, node.key, max);

    }



/*
    public TreeNode<K,V> delete(TreeNode<K,V> root, K key, V value){

        if(root==null)
            return null;

        if(root.key==key){
            root.value = value;

        }else if (key.compareTo(root.key)<0){
            root.left = insert(root.left, key, value);

        }else {
            root.right =  insert(root.right, key, value);

        }

        return root;
    }*/


    //delete
    //search -- contains
    //isEmpty
    //size

}
