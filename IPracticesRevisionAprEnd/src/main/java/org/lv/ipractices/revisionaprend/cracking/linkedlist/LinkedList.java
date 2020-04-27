package org.lv.ipractices.revisionaprend.cracking.linkedlist;

public class LinkedList<T> {

    LinkedNode<T> head;

    static class LinkedNode<T>{
        T data;
        LinkedNode<T> next;

        public LinkedNode(T data){
            this.data = data;
            this.next = null;

        }
    }

    public LinkedList(T data){
        this.head = new LinkedNode<>(data);
    }


    public void insert(T data){

        LinkedNode<T> newNode = new LinkedNode<>(data);

        if(head==null){
            head = newNode;
            return;
        }

        LinkedNode<T> curr = head;

        while(curr.next!=null){
            curr=curr.next;

        }
        curr.next = newNode;

    }


    public void delete(T data){
        System.out.println("Deleting : "+data);

        if(head==null){
            return;
        }

        if(head.data==data){
            head = null;
            return;
        }

        LinkedNode<T> curr = head;

        while(curr.next!=null){
            if(curr.next.data == data){
                curr.next = curr.next.next;
                return;
            }
            curr=curr.next;
        }

    }

    //search or contains
    public boolean contains(T data){

        if(head==null){
            return false;
        }

        LinkedNode<T> curr = head;

        while(curr!=null){
            if(curr.data == data){
                return true;
            }
            curr=curr.next;
        }
        return false;

    }

    public boolean isEmpty(){
        return head==null;
    }

    public void print(){
        LinkedNode<T> curr = head;

        while(curr!=null){
            System.out.println(curr.data + " -> ");
            curr = curr.next;
        }
    }

}
