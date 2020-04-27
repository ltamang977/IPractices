package org.lv.ipractices.datastructure;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T>{

    static class Node<T>{

        T val;
        Node<T> next;

        public Node(T val){
            this.val = val;
        }

    }

    Node<T> first=null;

    public LinkedStack(){

    }

    public boolean isEmpty(){
        return first==null;
    }


    public void push(T data){

        Node node = new Node(data);
        node.next = first;
        first = node;

    }


    public T pop(){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }

        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.val;
    }


    public Iterator<T> iterator(){

        return new Iterator<T>(){

            Node<T> node = first;

            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public T next() {

                if(!hasNext()){
                    throw new IllegalArgumentException("end reached");
                }

                T data = node.val;
                node = node.next;
                return data;
            }
        };
    }



    public static void main(String[] args){

        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.push(2);
        stack.push(3);

        Iterator<Integer> iter = stack.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }



    }



}
