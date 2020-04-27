package org.lv.ipractices.algorithms1.searching;

/**
 * Created by root on 12/23/17.
 */
public class Node<Key, Value>{
    public Key key;
    public Value value;
    public Node<Key,Value> next;

    public Node(Key key, Value value){
        this.key = key;
        this.value = value;
        next = null;
    }

}
