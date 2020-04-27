package org.lv.ipractices.dsa.stacksandqueues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPriorityQueue<T> implements  Iterable<T>{

    private T[] pq;
    int n;//size
    private Comparator<T> comparator;

    public MinPriorityQueue(int initialCapacity){
        pq = (T[]) new Object[initialCapacity+1];
        n=0;
        comparator=null;

    }

    public MinPriorityQueue(int initialCapacity, Comparator<T> comparator){
        pq = (T[]) new Object[initialCapacity+1];
        n=0;
        this.comparator=comparator;

    }

    public MinPriorityQueue(T[] arr){

        pq = (T[]) new Object[arr.length+1];
        n=arr.length;

        for(int i = 0; i<arr.length; i++){
            pq[i+1]=arr[i];
        }

        for(int i = n/2; i>=1; i--){
            pushDown(i);
        }

    }

    public void insert(T data){

        if(n==pq.length-1){
            resize(2*pq.length);
        }
        pq[++n]=data;
        pushUp(n);

    }

    public T min(){

        if(n==0){
            throw new NoSuchElementException();
        }
        return pq[1];

    }

    public T deleteMin(){

        if(n==0){
            throw new NoSuchElementException();
        }
        exchange(1, n);
        T min = pq[n];
        n--;
        pushDown(1);

        if(n>0 && n==(pq.length-1)/4)
            resize(pq.length/2);

        return min;

    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    private void pushUp(int i){

        while(i>1 && lessThan(i, i/2)){
            exchange(i,i/2);
            i=i/2;

        }

    }

    private void pushDown(int i){

        while(2*i<=n){
            int k = 2*i;
            if(k<n && lessThan(k+1, k)){
                k = k+1;
            }
            if(!lessThan(k, i)){
                break;
            }
            exchange(i,k);
            i = k;
        }



    }


    private void resize(int capacity){
        assert capacity>n;

        T[] temp = (T[]) new Object[capacity+1];
        for(int i=0; i<=n; i++){
            temp[i]=pq[i];
        }

        pq = temp;

    }

    private boolean lessThan(int i, int j){
        if(comparator==null){
            return (((Comparable<T>)pq[i]).compareTo(pq[j] ) < 0);

        } else {
            return comparator.compare(pq[i], pq[j])<0;
        }

    }

    public void exchange(int i, int j){
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

    }

    @Override
    public String toString() {

        //Arrays.toString(pq);
        System.out.println(Arrays.toString(pq));
        StringBuilder sb = new StringBuilder();
        for(T t : this){
            sb.append(t);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }


    class PriorityQueueIterator implements Iterator<T>{

        int i = 1;

        PriorityQueueIterator(){

        }


        @Override
        public boolean hasNext() {
            if(i<=n){
                return true;
            }
            return false;
        }

        @Override
        public T next() {

            if(!hasNext())
                throw new NoSuchElementException();

            T data = pq[i++];
            return data;
        }
    }


    public static void priorityQueueDemoWithInsert(){
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>(6);
        pq.insert(5);
        pq.insert(6);
        pq.insert(7);
        pq.insert(1);
        pq.insert(1);
        pq.insert(1);

        System.out.println(pq.toString());
    }

    public static void priorityQueueDemoWithArray(){

        Integer[] arr = new Integer[]{5, 6, 7, 8, 9, 1, 3, 5, 4};
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<Integer>(arr);

        System.out.println(pq.toString());

    }

    public static void main(String[] args){

        priorityQueueDemoWithArray();

    }


}
