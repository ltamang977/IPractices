package org.lv.ipractices.datastructure;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T>{

    T[] arr;
    int size;

    public ArrayStack(int n){

        arr = (T[]) new Object[n];
        this.size=0;

    }

    public boolean isEmpty(){
        return size==0;
    }

    public void push(T val){
        if(size==arr.length){
            resize(2*arr.length);
        }
        arr[size++]=val;

    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("");
        }
        T val =  arr[--size];

        if(size>0 && size==arr.length/4){
            resize(arr.length/2);
        }

        return val;

    }

    public void resize(int newSize){
        T[] newArr = (T[]) new Object[newSize];

        for(int i=0; i<size; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    public Iterator<T> iterator(){

        return new Iterator<T>(){

            int i = size-1;

            public boolean hasNext(){
                return i>=0;
            }

            public T next(){
                return arr[i--];
            }

        };

    }

    public static void main(String[] args){

        ArrayStack<Integer> stack = new ArrayStack<>(20);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        stack.pop();

        stack.push(6);
        stack.push(7);

        Iterator<Integer> itr = stack.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
