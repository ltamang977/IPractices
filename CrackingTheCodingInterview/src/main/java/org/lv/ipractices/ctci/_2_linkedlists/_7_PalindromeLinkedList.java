package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/31/17.
 * todod
 */
public class _7_PalindromeLinkedList {

    public static void checkPalindrome(Node first) {

        Node i= first;
        Node j = i;

        //find last node
        while(j.next!=null){
            j = j.next;
        }

        //1. either add prev to trace back
        //2. count the index of the linked list so can use advantage of mid

    }
}
