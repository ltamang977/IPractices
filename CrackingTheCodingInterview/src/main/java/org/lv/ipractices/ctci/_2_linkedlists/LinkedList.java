package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/30/17.
 */
public class LinkedList {

    public Node first;

    public LinkedList(){

    }

    public LinkedList(Node first){
        this.first = new Node(first.data);
    }

    public Node getFirst(){
        return first;
    }

    public void insert(int d){

        Node n = new Node(d);

        if(first==null) {
            first = n;
            return;
        }

        Node current = first;
        while (current.next!=null){
            current = current.next;

        }
        current.next = n;

    }

    public void prepend(Node n){
        n.next = first;
        first = n;
    }
    public void append(Node d){

        if(first==null) {
            first = d;
            return;
        }

        Node current = first;
        while (current.next!=null){
            current = current.next;

        }
        current.next = d;

    }



    public Node delete(int d){


        if(first==null) {
            return null;
        }

        if(first.data==d){
            first=first.next;
            return first;
        }

        Node current = first;
        while (current.next!=null){
            if(current.next.data==d){
                current.next = current.next.next;
                return first;
            }
            current = current.next;
        }
        return first;

    }

    public void print(){
        Node current = first;
        while(current!=null){
            System.out.printf("%d\t",current.data);
            current = current.next;
        }
        System.out.println();
    }
}
