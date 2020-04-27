package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/28/18.
 */
public class OddEvenLinkedList {


    public static LinkedNode oddEvenLinkedList(LinkedNode head){

        LinkedNode odd = head;
        LinkedNode even = head.next;
        LinkedNode evenHead = head.next;


        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd= odd.next;
            even.next = odd.next;
            even=even.next;
        }
        odd.next = evenHead;
        return head;

    }


    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(1);
        nbr1.appendToLast( 2);
       // nbr1.appendToLast(6);
        nbr1.appendToLast(3);
        nbr1.appendToLast( 4);
        nbr1.appendToLast(5);
        nbr1.appendToLast(6);
        nbr1.printList();

        // LinkedNode head = removeElement(nbr1, 6);
        LinkedNode head = oddEvenLinkedList(nbr1);
        head.printList();

    }
}
