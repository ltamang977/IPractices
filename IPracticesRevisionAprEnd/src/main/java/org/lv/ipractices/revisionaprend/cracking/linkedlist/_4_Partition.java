package org.lv.ipractices.revisionaprend.cracking.linkedlist;

public class _4_Partition {


    public static LinkedList.LinkedNode<Integer>  partition(LinkedList.LinkedNode<Integer> head, int partition){

        LinkedList.LinkedNode<Integer> leftHead = new LinkedList.LinkedNode<>(0);
        LinkedList.LinkedNode<Integer> leftTail = leftHead;

        LinkedList.LinkedNode<Integer> rightHead = new LinkedList.LinkedNode<>(0);
        LinkedList.LinkedNode<Integer> rightTail = rightHead;


        LinkedList.LinkedNode<Integer> curr = head;

        while(curr!=null){
            if(curr.data<partition){
                LinkedList.LinkedNode<Integer> next = curr.next;
                curr.next = null;
                leftTail.next = curr;
                leftTail= leftTail.next;
                curr=next;
            }else {
                LinkedList.LinkedNode<Integer> next = curr.next;
                curr.next = null;
                rightTail.next = curr;
                rightTail= rightTail.next;
                curr = next;
            }
        }

        leftTail.next = rightHead.next;
        return leftHead.next;


    }


    public static void main(String[] args){
        org.lv.ipractices.revisionaprend.cracking.linkedlist.LinkedList<Integer> linkedList
                = new  org.lv.ipractices.revisionaprend.cracking.linkedlist.LinkedList<Integer>(3);
        linkedList.insert(5);
        linkedList.insert(8);
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(2);
        linkedList.insert(1);
        System.out.println("Printing linked list :");
        linkedList.print();


        LinkedList.LinkedNode<Integer>  partitionHead = partition(linkedList.head,  10);

        System.out.println("Printing partition list:");
        LinkedList.LinkedNode<Integer>  curr = partitionHead;
        while(curr!=null){
            System.out.println("->"+curr.data);
            curr = curr.next;
        }
    }
}
