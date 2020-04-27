package org.lv.ipractices.datastructure;

import java.util.Iterator;
public class LinkedQueue<T> implements Iterable<T>{

    class Node<T>{
        T val;
        Node<T> next;

        public Node(T val){
            this.val = val;

        }
    }

    Node<T> first=null;
    Node<T> last=null;

    public LinkedQueue(){

    }

    public boolean isEmpty(){
        return first==null;
    }

    public void offer(T val){

        Node node = new Node<T>(val);

        if(last==null){
            last=node;

        }else{
            last.next = node;
            last = node;

        }

        if(first==null){
            first=last;
        }

    }

    public T poll(){

        if(isEmpty()){
            throw  new IllegalArgumentException("");
        }

        Node<T> oldFirst = first;
        first = first.next;

        if(first==null)
            last=null;

        return oldFirst.val;

    }


    public Iterator<T> iterator(){

        return new Iterator<T>(){

            Node<T> node=first;

            public boolean hasNext(){

                return node!=null;

            }

            public T next(){
                Node<T> old = node;
                node=node.next;
                return old.val;
            }
        };

    }



    public static void main(String[] args){

        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll();
        queue.poll();
        queue.offer(4);
        queue.offer(5);

        Iterator<Integer> itr = queue.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
