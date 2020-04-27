package org.lv.ipractices.dsa.stacksandqueues;

import org.lv.ipractices.dsa.LinkedNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueFromNodes<T> implements  Iterable<T> {


    private LinkedNode<T> first;
    private LinkedNode<T> last;
    int n=0;


    public QueueFromNodes(){
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    public void enqueue(T data){
        LinkedNode<T> oldLast = last;

        last = new LinkedNode<>(data);

        if(isEmpty()){
            first=last;

        }else{
            oldLast.next = last;
        }

    }

    public T dequeue(){

        if(isEmpty())
            throw new NoSuchElementException();

        T data = first.data;
        first = first.next;

        if(isEmpty()){
            last=null;
        }

        return data;

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
        return new QueueIterator(first);
    }


    public static class QueueIterator<T> implements  Iterator<T>{

        private LinkedNode<T> current;


        public QueueIterator(LinkedNode<T> first){
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
