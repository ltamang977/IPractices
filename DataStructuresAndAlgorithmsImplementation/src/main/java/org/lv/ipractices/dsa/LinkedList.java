package org.lv.ipractices.dsa;

public class LinkedList<E> {

    class Node<E>{
        E data;
        Node<E> next;

        public Node(E e){
            this.data = e;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head = null;
        currentSize = 0;
    }


    public void addFirst(E obj){
        Node<E> node = new Node<>(obj);
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<>(obj);
        if(head==null){
            head=tail=node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

   /* public E removeFirst(){

        if(head==null)
            return null;

        E temp = head.data;

    }*/
}
