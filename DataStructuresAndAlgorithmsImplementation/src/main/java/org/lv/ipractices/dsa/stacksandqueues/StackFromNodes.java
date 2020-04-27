package org.lv.ipractices.dsa.stacksandqueues;

import org.lv.ipractices.dsa.LinkedNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackFromNodes<T> implements  Iterable<T> {

    private LinkedNode<T> first;
    private int n;


    public StackFromNodes(){
        this.first = null;
        this.n = 0;

    }

    public void push(T data){

        LinkedNode<T> oldFirst = first;
        first  = new LinkedNode<>(data);
        first.next = oldFirst;

    }


    public T pop(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        T data = first.data;
        first=first.next;

        return data;

    }


    public T peek(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return first.data;

    }


    public boolean isEmpty(){
        return first==null;
    }

    public int size(){
        return n;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(T data : this){
            sb.append(data);
            sb.append(' ');
        }

        return sb.toString();
    }



    @Override
    public Iterator<T> iterator() {
        return new StackFromNodesIterator(first);
    }

    public class StackFromNodesIterator<T> implements  Iterator<T>{

        private LinkedNode<T> current;

        public StackFromNodesIterator(LinkedNode<T> first){
            this.current = first;

        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            T data = current.data;
            current = current.next;

            return data;
        }
    }
}
