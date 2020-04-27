package org.lv.ipractices.dsa.stacksandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueFromArray<T> implements  Iterable<T> {

    T[] arr;
    int n;
    int first;
    int last;

    public QueueFromArray(){
        arr = (T[]) new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }

    public void enqueue(T data){
        if(n==arr.length)
            resize( 2*n);
        arr[last++]=data;

        if(last==arr.length)
            last = 0;//wrap around

        n++;

    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        T data = arr[first];
        arr[first]=null;
        first++;

        if(first==arr.length){
            first = 0;//wrap around
        }

        n--;

        if(n>0 && n==arr.length/4)
            resize(arr.length/2);


        return data;

    }


    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return arr[first];

    }


    private void resize(int capacity){

        assert capacity>=n;

        T[] temp = (T[]) new Object[capacity];

        for(int i=0; i<n; i++){
            temp[i]=arr[(first+i)%arr.length];
        }

        arr = temp;
        first = 0;
        last = n;

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
        return new QueueFromArrayIterator();
    }


    public class QueueFromArrayIterator implements  Iterator<T>{

        int i=0;

        public QueueFromArrayIterator(){
        }

        @Override
        public boolean hasNext() {
            return i<n;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();

            T data = arr[(first+i)%arr.length];
            i++;
            return data;
        }
    }
}
