package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/27/18.
 */

import java.util.Set;
import java.util.HashSet;

public class Cycle {



    /**
     * uses HashTable
     * @param head
     * @return
     */
    public static boolean isCyclicHashTable(LinkedNode head){

        Set<LinkedNode> set = new HashSet<>();

        while(head!=null){
            if (set.contains(head)) {
                return true;//head is begin of cycle too

            }else {
                set.add(head);
            }
            head= head.next;
        }

        return false;

    }



    /**
     * uses two pointers
     * @param head
     * @return
     */
    public static boolean isCyclicTwoPointers(LinkedNode head){

        LinkedNode slow = head;
        LinkedNode fast = head.next;

        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
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
        nbr1.appendToLast(3);
        nbr1.appendToLast(4);
        nbr1.appendToLast( 5);
        nbr1.appendToLast(6);
        nbr1.printList();

       // boolean flag= isCyclicHashTable(nbr1);
        boolean flag = isCyclicTwoPointers(nbr1);
        System.out.println("Result is :"+flag);

    }
}
