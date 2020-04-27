package org.lv.ipractices.revisionaprend.cracking;

public class MyStack<T extends Comparable<T>> {

    StackNode<T> top = null;


    private static class StackNode<T>{
        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }


    public MyStack(T data){
        top = new StackNode(data);
    }


    public T pop(){
        if(top==null)
            throw new IllegalStateException("top is null");

        StackNode<T> node = top;
        top=top.next;

        node.next=null;

        System.out.println("Pushing :"+node.data);

        return node.data;

    }

    public T peek(){
        if(top==null)
            throw new IllegalStateException("top is null");

        StackNode<T> node = top;
        return node.data;

    }

    public void push(T data){

        System.out.println("Pushing :"+data);
        if(top==null)
            throw new IllegalStateException("top is null");

        StackNode<T> node = new StackNode<>(data);
        node.next = top;
        top= node;

    }

    public boolean isEmpty(){
        return top==null;
    }
}
