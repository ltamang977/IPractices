package org.lv.ipractices.hackerrank.linkedlists;

public class LinkedLists {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
        }
    }



    static Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.

        if(head==null){
            if(position==0){
                head = new Node(data);
                return head;
            }
            return null;
        }

        //find position-1 node and set next

        int i=1;
        Node current = head;
        for(; i<=position-1; i++){
            if(current==null){
                return null;
            }
            current = current.next;
        }

        if(current==null){
            return null;
        }

        Node next = current.next;
        current.next = new Node(data);
        current.next.next = next;

        return head;
    }

    static void Print(Node head) {

        if(head==null)
            return;

        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }


    }


    public static void main(String[] args){

        /*
        5
        3 0
        5 1
        4 2
        2 3
        10 1
         */

        LinkedLists.Node head = null;
        Node node = InsertNth(head, 3, 0);
        node = InsertNth(node, 5, 1);
        node = InsertNth(node, 4, 2);
        node = InsertNth(node, 2, 3);
        node = InsertNth(node, 10, 1);


        Print(node);
    }
}
