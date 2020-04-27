package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/20/18.
 */
public class LinkedNode {

    public int data;
    public LinkedNode next;

    public LinkedNode(int data){
        this.data = data;
        this.next = null;
    }

    public void appendToLast( int data){

        LinkedNode node = this;
        while(node.next!=null){
            node = node.next;
        }
        node.next = new LinkedNode(data);

    }

    public void printList(){
        LinkedNode node = this;
        System.out.println();
        while(node!=null){
            System.out.printf("%d ->",node.data);
            node = node.next;
        }

    }
}
