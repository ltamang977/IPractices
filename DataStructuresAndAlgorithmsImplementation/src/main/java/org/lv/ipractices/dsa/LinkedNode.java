package org.lv.ipractices.dsa;

public class LinkedNode<T> {

    public T data;
    public LinkedNode<T> next = null;


    public LinkedNode(T data){
        this.data = data;
        this.next = null;
    }
}
