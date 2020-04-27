package org.lv.ipractices.datastructure;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T>{

    T[] arr;
    int size = 0;
    int left=0;
    int right=0;

    public ArrayQueue(int n){
        arr = (T[]) new Object[n];

    }


    public boolean isEmpty(){
        return size==0;
    }

    public void offer(T val){

        if(size==arr.length){
            resize(2*arr.length);
        }
        arr[right++]=val;
        size++;

        if(right==arr.length){
            right=0;//wrap around
        }


    }

    public T poll(){

        if(isEmpty()){
            throw new IllegalArgumentException("");
        }

        T val =  arr[left];
        arr[left]=null;
        left++;
        size--;

        if(left==arr.length){
            left=0;
        }

        return val;

    }

    public Iterator<T> iterator(){

        return new Iterator<T>(){

            int i = 0;

            public boolean hasNext(){
                return i<size;
            }

            public T next(){
                T val = arr[(left+i)%arr.length];
                i++;
                return val;
            }

        };

    }

    public void resize(int newSize){
        T[] newArr = (T[]) new Object[newSize];

        for(int i=0; i<size; i++){
            newArr[i]=arr[(left+i)%arr.length];
        }
        arr = newArr;
        left=0;
        right=size;
    }


    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);

        for(int i=0; i<15; i++){
            queue.offer(i);
        }

        for(int i=0; i<5; i++){
            queue.poll();
        }

        for(int i=16; i<20; i++){
            queue.offer(i);
        }

        Iterator<Integer> itr = queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
