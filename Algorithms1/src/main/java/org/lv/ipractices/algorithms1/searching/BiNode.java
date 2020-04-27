package org.lv.ipractices.algorithms1.searching;

/**
 * Created by root on 12/24/17.
 */
public class BiNode<Key extends Comparable<Key>, Value> {

    Key key;
    Value value;
    BiNode left;
    BiNode right;
    int count;

    public BiNode(Key key, Value value){
        this.key = key;
        this.value= value;
        this.left = null;
        this.right = null;
        this.count = 1;
    }

}
