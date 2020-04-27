package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/27/18.
 */
public class RotateLInkedLIst {

    public static LinkedNode rotateLinkedList(LinkedNode head, int k){

        LinkedNode prevNode = head;
        LinkedNode node = head;

        int i =1;
        while(i<=3 && node!=null){
            prevNode = node;
            node = node.next;//move right 3 times
            i++;
        }

        prevNode.next=null;


        LinkedNode endNode= node;
        while(endNode.next!=null){
            endNode = endNode.next;
        }
        endNode.next = head;

        head = node;
        return head;

    }


    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(1);
        nbr1.appendToLast( 2);
        nbr1.appendToLast(3);
        nbr1.appendToLast(4);
        nbr1.appendToLast( 5);
        nbr1.printList();


        LinkedNode head = rotateLinkedList(nbr1, 3);
        head.printList();

    }
}
