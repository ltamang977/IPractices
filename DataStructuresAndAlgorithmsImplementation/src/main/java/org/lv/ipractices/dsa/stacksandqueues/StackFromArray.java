package org.lv.ipractices.dsa.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackFromArray<T> implements  Iterable<T> {

    T[] arr;
    int n;

    public StackFromArray(){
        arr = (T[]) new Object[2];
        n = 0;
    }

    public void push(T data){
        if(n==arr.length)
            resize( 2*n);
        arr[n++]=data;

    }

    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        T data = arr[n-1];
        arr[n-1]=null;
        n--;

        if(n==arr.length/4)
            resize(arr.length/2);

        return data;

    }


    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return arr[n-1];

    }


    private void resize(int capacity){

        assert capacity>=n;

        T[] temp = (T[]) new Object[capacity];

        for(int i=0; i<n; i++){
            temp[i]=arr[i];
        }

        arr = temp;

    }


    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n==0;
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
        return new StackFromArrayIterator();
    }


    public class StackFromArrayIterator implements  Iterator<T>{

        int i;
        public StackFromArrayIterator(){
            this.i = n-1;
        }

        @Override
        public boolean hasNext() {
            return i>=0;
        }

        @Override
        public T next() {
            return arr[i--];
        }
    }
}
