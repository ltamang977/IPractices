package org.lv.ipractices.revisionaprend.cracking;

public class MyQueue<T extends Comparable<T>> {


    private QueueNode<T> head = null;
    private QueueNode<T> tail = null;


    private static class QueueNode<T>{
        T data;
        QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue(T data){
        this.head=this.tail=new QueueNode<>(data);

    }


    public void add(T data){
        System.out.println("Adding :"+data);
        QueueNode<T> node = new QueueNode<>(data);

        if(tail==null){
            head=tail = node;
            return;
        }

        tail.next = node;
        tail=node;

    }

    public T remove(){

        if(head==null){
            throw new IllegalArgumentException("head is null");
        }

        QueueNode<T> node = head;
        head=head.next;
        node.next = null;

        if(head==null)
            tail=null;
        System.out.println("Removing :"+node.data);

        return node.data;

    }

    public boolean isEmpty(){
        return head==null;
    }

}
