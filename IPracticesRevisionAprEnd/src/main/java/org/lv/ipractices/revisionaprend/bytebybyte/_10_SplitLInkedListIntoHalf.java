package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.List;

public class _10_SplitLInkedListIntoHalf {


    public static LinkedList.LinkedNode<Integer>  splitALinkedList(LinkedList<Integer> linkedList){

        if(linkedList.head==null)
            return null;

        LinkedList.LinkedNode<Integer> firstTail = linkedList.head;
        LinkedList.LinkedNode<Integer> slow = linkedList.head;
        LinkedList.LinkedNode<Integer> fast = linkedList.head;

        while(fast!=null && fast.next!=null){
            firstTail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList.LinkedNode<Integer> toReturn = firstTail.next;
        firstTail.next=null;

        return toReturn;

    }



    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);

        System.out.println("Printing linked list :");
        linkedList.print();

        //splitALinkedList
        System.out.println("Second half head is :"+splitALinkedList(linkedList).data);
        linkedList.print();

    }
}
