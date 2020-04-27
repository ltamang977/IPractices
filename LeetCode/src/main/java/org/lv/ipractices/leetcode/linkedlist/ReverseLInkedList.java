package org.lv.ipractices.leetcode.linkedlist;

/**
 * Created by root on 1/27/18.
 */
public class ReverseLInkedList {


    /**
     * my solution
     * @param node
     * @return
     */
    public static LinkedNode reverseList(LinkedNode node){

        if(node==null)
            return node;


        LinkedNode rtn = reverseList(node.next);
        if(rtn==null){
            return node;
        }else{
            node.next=null;
            LinkedNode head = rtn;
            while(rtn.next!=null){
                rtn= rtn.next;
            }
            rtn.next = node;
            return head;
        }

    }


    /**
     * proper solution
     * @param head
     * @return
     */
    public static LinkedNode reverseIterative(LinkedNode head){

        LinkedNode prev = null;
        LinkedNode curr = head;

        while(curr!=null){
            LinkedNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

    }

    /**
     * proper solution
     * @param node
     * @return
     */
    public static LinkedNode reverseRecursive(LinkedNode node){

        if(node==null || node.next==null){
            return node;
        }

        LinkedNode p = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return p;
    }


    /**
     * proper solution
     * @param head
     * @return
     */
    public static LinkedNode reverseMToN(LinkedNode head, int m , int n){

        LinkedNode prevLeft = null;
        LinkedNode left = head;

        int i=1;
        while(i<m){
            prevLeft = left;
            left=left.next;
            i++;
        }


        LinkedNode prevRight = null;
        LinkedNode right = head;

        i=1;
        while(i<=n){
            prevRight = right;
            right=right.next;
            i++;
        }

        LinkedNode prev = right;
        LinkedNode curr = left;

        int times = n-m;
        while(times>=0){
            LinkedNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            times--;
        }

        if(m!=1){//not first element
            prevLeft.next = prev;
            return head;
        }else {
            //prevLeft will be null
            return prev;
        }

    }



    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(1);
        nbr1.appendToLast( 2);
        nbr1.appendToLast(3);
        nbr1.appendToLast(4);
        nbr1.appendToLast( 5);
        nbr1.appendToLast(6);
        nbr1.printList();


        //LinkedNode head = reverseList(nbr1);
        //LinkedNode head = reverseIterative(nbr1);
       // LinkedNode head = reverseRecursive(nbr1);
        LinkedNode head = reverseMToN(nbr1, 2,4);
        head.printList();

    }
}
