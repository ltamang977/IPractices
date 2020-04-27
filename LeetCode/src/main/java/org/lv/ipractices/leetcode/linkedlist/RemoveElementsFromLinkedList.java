package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/27/18.
 */

import java.util.HashSet;
import java.util.Set;

public class RemoveElementsFromLinkedList {



    /**
     * uses HashTable
     * @param head
     * @return
     */
    public static LinkedNode removeElement(LinkedNode head, int value){


        LinkedNode node = head;
        if(head.data==6){
            head=head.next;
        }


        while(node!=null && node.next!=null){
            if (node.next.data==value) {
                node.next = node.next.next;

            }
            node=node.next;
        }

        return head;

    }



    /**
     * uses two pointers
     * @param node
     * @return
     */
    public static void deleteNode(LinkedNode node){

        LinkedNode next = node.next;
        node.data=next.data;
        node.next = next.next;

    }


    /**
     * uses two pointers
     * @param head
     * @return
     */
    public static LinkedNode intersectionTwoPointers(LinkedNode head){

        LinkedNode slow = head;
        LinkedNode fast = head.next;

        while(fast!=null && fast.next!=null){
            if(slow==fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return null;
    }

    /**
     * to find begin of cycle
     * @param head
     * @return
     */
    public static LinkedNode beginOfCycle(LinkedNode head){

        LinkedNode intersectionNode = intersectionTwoPointers(head);

        LinkedNode ptr1 = head;
        LinkedNode ptr2 = intersectionNode;

        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }



    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(1);
        nbr1.appendToLast( 2);
        nbr1.appendToLast(6);
        nbr1.appendToLast(3);
        nbr1.appendToLast( 4);
        nbr1.appendToLast(5);
        nbr1.appendToLast(6);
        nbr1.printList();

       // LinkedNode head = removeElement(nbr1, 6);
        deleteNode(nbr1.next.next);
        nbr1.printList();

    }
}
