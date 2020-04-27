package org.lv.ipractices.dsa;

import java.util.Arrays;
import java.util.Collection;

/**
 * Stack implementation using array
 */
public class Stack<E> {

    private E[] elements;
    private int size=0;
    private static final int DEFAULT_INITIAL_CAPACITY=16;

    public Stack(){
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }


    public void push(E e){
        //ensureCapacity
        elements[size++]=e;
    }


    public E pop(){
        if(size==0){
            //throw empty stack exception
        }

        E result = elements[--size];
        elements[size]=null;
        return result;
    }

    public boolean isEmpty(){
        return  size==0;
    }

    public void ensureCapacity(){
        if(elements.length==size){
            elements = Arrays.copyOf(elements, 2*size+1);
        }
    }


    // used extends for producer -- > E producer
    public void pushAll(Iterable<? extends  E> src){
        for(E e : src){
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst){
        while(!isEmpty()){
            dst.add(pop());
        }
    }


    /**
    public static <T extends Comparable<T>> T max(List<T> list)

    -- >

    public static <T extends Comparable<? super T>> T max(List<? extends T> list)
     */


    public static void main(String[] args){
        Stack<String> stack = new Stack<>();

        for(String arg : args)
            stack.push(arg);

        while(!stack.isEmpty()){
            System.out.println(stack.pop().toUpperCase());
        }

    }
}
