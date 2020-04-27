package org.lv.ipractices.leetcode.linkedlist;

import sun.awt.image.ImageWatched;

/**
 * Created by root on 1/27/18.
 */
public class PartitionList {


    public static LinkedNode partitionList(LinkedNode head, int mid){


        LinkedNode dummyLeft = new LinkedNode(0);
        LinkedNode left = dummyLeft;

        LinkedNode dummyRight = new LinkedNode(0);
        LinkedNode right = dummyRight;

        LinkedNode node = head;

        while(node!=null){
            if(node.data<mid){
                left.next = node;
                left = left.next;
            }else {
                right.next = node;
                right = right.next;
            }
            node=node.next;
        }
        right.next = null;

        left.next = dummyRight.next;
        LinkedNode newHead = dummyLeft.next;
        return newHead;

    }


    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(1);
        nbr1.appendToLast( 4);
        nbr1.appendToLast(3);
        nbr1.appendToLast(2);
        nbr1.appendToLast( 5);
        nbr1.appendToLast(2);
        nbr1.printList();


        LinkedNode head = partitionList(nbr1, 3);
        head.printList();

    }
}
