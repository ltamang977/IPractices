package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.Arrays;

public class MyStack<T extends Comparable<T>> {

    T[] arr;
    int n;
    java.util.Stack<T> maxStack;

    public MyStack(int capacity){
        arr = (T[]) new Comparable[capacity];
        n = 0;
        maxStack = new java.util.Stack();
    }

    //O(1)
    public void push(T data){

        System.out.println("Pushing :"+data);
        arr[n++]=data;

        if(maxStack.isEmpty() || data.compareTo(maxStack.peek())>=0){
            maxStack.push(data);
        }
    }


    public T peek(){
        if(n==0)
            return null;

        T item = arr[n-1];
        System.out.println("Peeked item is  :"+item);
        return item;
    }



    //O(n)
    public T pop(){

        if(n==0)
            return null;

        T item = arr[--n];
        System.out.println("Popping :"+item);
        if(maxStack.peek().compareTo(item)==0) {
            maxStack.pop();
        }
        return item;
    }

    //O(1)
    public T max(){
        return maxStack.peek();
    }

    //O(1)
    public boolean isEmpty(){
        return n==0;
    }

    public void print(){
        System.out.println("Printing stack contents :");
        System.out.println(Arrays.toString(arr));
    }

}
