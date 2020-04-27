package org.lv.ipractices.algorithms1.searching;

import java.util.Iterator;

/**
 * Created by root on 12/24/17.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Iterable<Key>{
    BiNode root;

    public BinarySearchTree(){

    }

    public BinarySearchTree(Key key, Value value){
        root = new BiNode(key, value);

    }

    //insert or update ??
    //tree is sorted by key
    //so if key is not present it will insert new node
    // if already present ,,, it will just update the value
    public void put(Key key, Value value){
        root = put(root, key, value);
    }


    public BiNode put(BiNode node, Key key, Value value){
        //insert or update ??

        if(node==null)
            return new BiNode(key, value);
        //
        if(key.compareTo((Key)node.key)<0){
            node.left = put(node.left, key, value);

        } else if (key.compareTo((Key)node.key)>0){
            node.right = put(node.right, key, value);

        } else {
            node.value = value;
        }

        node.count = count(node.left) + count(node.right) +1;

        return node;
    }

    public int count(BiNode node){
        if(node == null)
            return 0;
        else
            return node.count;
    }

    //search
    public Value get(Key key){
        BiNode node = get(root, key);
        if(node == null)
            return null;
        else
            return (Value) node.value;
    }

    public BiNode get(BiNode node, Key key){

        if(node==null)
            return node;
        //
        if(key.compareTo((Key)node.key)<0){
            return get(node.left, key);

        } else if (key.compareTo((Key)node.key)>0){
            return get(node.right, key);

        } else {
            return node;
        }
    }


    public int rank(Key key){
        return rank(root, key);
    }


    /**
     * number of elements less than key
     * @return
     */
    public int rank( BiNode node, Key key){

        if(node == null){
            return 0;
        }

        int cmp = key.compareTo((Key) node.key);

        if(cmp < 0){
           return rank(node.left, key);

        }else if(cmp>0){
           return 1+count(node.left)+rank(node.right, key);

        } else {
            return count(node.left);
        }


    }

    /**
     * Min is the left most element in the tree
     * @param node
     * @param key
     * @return
     */
    public BiNode min(BiNode node, Key key){
        if(node == null)
            return null;

        int cmp = key.compareTo((Key)node.key);

        node.left = min(node.left, key);


        return null;
    }

    public BiNode minIter(){
        BiNode current = root;
        if(current == null)
            return null;

        if(current.left == null)
            return current;

        BiNode parent = current;
        while(current!=null){
            parent = current;
            current = current.left;
        }

        return parent;

    }

    public Key minRecur(){
        BiNode minNode = minRecur(root);
        if(minNode==null)
            return null;
        else
            return (Key)minNode.key;
    }

    public BiNode minRecur(BiNode node){
        if(node == null)
            return null;

        BiNode r = minRecur(node.right);
        if(r==null)
            return node;
        else
            return r;

    }

    public BiNode maxIter(){
        BiNode current = root;
        if(current == null)
            return null;

        if(current.right == null)
            return current;

        BiNode parent = current;
        while(current!=null){
            parent= current;
            current = current.right;
        }

        return parent;

    }

    public Key maxRecur(){
        BiNode minNode = minRecur(root);
        if(minNode==null)
            return null;
        else
            return (Key)minNode.key;
    }

    public BiNode maxRecur(BiNode node){
        if(node == null)
            return null;

        BiNode r = maxRecur(node.left);
        if(r==null)
            return node;
        else
            return r;

    }



    public BiNode deleteMin(BiNode node){
        if(node.left==null)
            return node.right;
        node.left = deleteMin(node.left);
        node.count = 1+count(node.left)+count(node.right);
        return node;
    }
    //delete

    public void delete(Key key) {
        delete(root, key);
    }

    public BiNode delete(BiNode node, Key key){
        if(node==null)
            return null;

        int cmp = key.compareTo((Key)node.key);
        if(cmp<0) {
            node.left = delete(node.left, key);

        }else if(cmp>0){
            node.right = delete(node.right, key);

        }else {

            //found it
            //no children
            if(node.left==null && node.right==null){
                return null;
            }

            //only left child
            if(node.right==null){
                return node.left;
            }

            //only right child
            if(node.left==null){
                return node.right;
            }

            //both children present
            BiNode t = node;
            node = minRecur(node.right);
            node.left = t.left;
            node.right =deleteMin(t.right);


        }

        node.count = 1+count(node.left)+count(node.right);
        return node;//when no children
    }


    //floor of given key .... largest number less than equal to key
    //ceiling ... smallest number greate than or equal to key

    public Value floor(Key key){
        BiNode floorNode =floor(root, key);
        if(floorNode == null)
            return null;
        else
            return (Value)floorNode.value;
    }

    public BiNode floor(BiNode node, Key key){

        if(node == null)
            return null;

        int cmp = key.compareTo((Key)node.key);

        if(cmp == 0)
            return node;

        if(cmp<0)
            return floor(node.left, key);

        BiNode r = floor(node.right, key);
        if(r!=null)
            return r;
        else
            return node;

    }

    //delete
    //rank
    //contains
    //empty

    public void print(){
        print(root);
    }

    //print inorder
    public void print(BiNode node){

        if(node == null)
            return;

        System.out.println("Left");
        print(node.left);
        System.out.println("        Value is :"+node.value);
        System.out.println("Right");
        print(node.right);

    }


    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private class BinarySearchTreeIterator<Key> implements Iterator<Key>{

        Key rootKey;

        public BinarySearchTreeIterator(Key key){
            this.rootKey = key;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Key next() {
            return null;
        }
    }


    public static void main(String[] args){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree();

        bst.put(1, "A");
        bst.put(0,"L");
        bst.put(2, "B");
       // bst.put(3, "I");
        bst.put(4, "N");

        bst.put(8, "A");
        bst.put(6, "A");
        bst.put(10, "G");
        bst.put(5, "T");
        bst.put(7, "M");
        bst.put(9, "N");

        bst.print();


        String twoValue = bst.get(2);
        System.out.println("Value of 2 is :"+twoValue);

        System.out.println("Floor of key 3 is :"+bst.floor(3));

        System.out.println("Rank of key 3 is :"+bst.rank(12));


        System.out.println("Min using iteration is :"+bst.minIter().key);
        System.out.println("Max using iteration is :"+bst.maxIter().key);

        System.out.println("Min using recursion is :"+bst.minRecur());
        System.out.println("Max using recursion is :"+bst.maxRecur());

        System.out.println("Deleting 4");
        bst.delete(4);

        System.out.println("printing tree again");
        bst.print();


    }

}
