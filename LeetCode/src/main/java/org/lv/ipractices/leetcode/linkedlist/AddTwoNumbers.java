package org.lv.ipractices.leetcode.linkedlist;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Stack;

/**
 * Created by root on 1/20/18.
 */
public class AddTwoNumbers {

    /** Input and result in same order :
     * example :
     * nbr1 : 3 -> 4 -> 2
     * nbr2 : 4 -> 6 -> 5
     * rest : 7 -> 0 -> 8
     * @param nbr1
     * @param nbr2
     * @param carry
     * @return
     */
    public static LinkedNode addTwoNumbers(LinkedNode nbr1,
                                    LinkedNode nbr2,
                                    int carry){

        if(nbr1==null && nbr2==null) {
            if(carry!=0){
                return new LinkedNode(carry);
            }
            return null;
        }

        int sum = ((nbr1!=null)?nbr1.data:0)+((nbr2!=null)?nbr2.data:0)+carry;

        LinkedNode curr = new LinkedNode(sum%10);
        System.out.println("Current :"+curr.data);
        curr.next = addTwoNumbers((nbr1!=null)?nbr1.next:null,
                                (nbr2!=null)? nbr2.next:null,
                                sum/10);

        return curr;

    }

    /** Result reverse order from input
     * example :
     * nbr1 : 3 -> 4 -> 2
     * nbr2 : 4 -> 6 -> 5
     * rest : 8 -> 0 -> 7
     * @param nbr1
     * @param nbr2
     * @param carry
     * @return
     */
    public static LinkedNode addTwoNumbersReverse(LinkedNode nbr1,
                                                  LinkedNode nbr2,
                                                  int carry,
                                                  LinkedNode result){

        if(nbr1==null && nbr2==null) {
            if(carry!=0){
                LinkedNode n = new LinkedNode(carry);
                n.next = result;
                return n;
            }
            return result;
        }

        int sum = ((nbr1!=null)?nbr1.data:0)+((nbr2!=null)?nbr2.data:0)+carry;

        LinkedNode curr = new LinkedNode(sum%10);
        curr.next = result;

        System.out.println("Current :"+curr.data);
        LinkedNode node  = addTwoNumbersReverse((nbr1!=null)?nbr1.next:null,
                                        (nbr2!=null)? nbr2.next:null,
                                        sum/10, curr);

        return node;

    }


    public static LinkedNode addTwoNumberIteration(LinkedNode nbr1, LinkedNode nbr2){

        LinkedNode resultNode = new LinkedNode(0);
        LinkedNode current = resultNode;
        int count = 0;
        while(nbr1!=null || nbr2!=null){

            int sum = ((nbr1!=null)?nbr1.data:0)+((nbr2!=null)?nbr2.data:0) +count;

            count = sum/10;

            current.next =new LinkedNode(sum%10);

            nbr1= (nbr1!=null)?nbr1.next:null;
            nbr2 = (nbr2!=null)?nbr2.next:null;
            current = current.next;

        }

        if(count!=0){
            current.next = new LinkedNode(count);
        }

        return resultNode.next;

    }

    public static LinkedNode addTwoNumberIterationReverse(LinkedNode nbr1,
                                                          LinkedNode nbr2){

        LinkedNode resultNode = new LinkedNode(0);
        LinkedNode current = resultNode;
        int count = 0;

        while(nbr1!=null || nbr2!=null){

            int sum = ((nbr1!=null)?nbr1.data:0)+((nbr2!=null)?nbr2.data:0) +count;

            count = sum/10;

            current.next =new LinkedNode(sum%10);

            nbr1= (nbr1!=null)?nbr1.next:null;
            nbr2 = (nbr2!=null)?nbr2.next:null;
            current = current.next;

        }

        if(count!=0){
            current.next = new LinkedNode(count);
        }

        return resultNode.next;

    }

    public static void main(String[] args){

        LinkedNode nbr1 = new LinkedNode(3);
        nbr1.appendToLast( 4);
       // nbr1.appendToLast(9);
        nbr1.printList();

        LinkedNode nbr2 = new LinkedNode(4);
        nbr2.appendToLast( 6);
        //nbr2.appendToLast(9);
        nbr2.printList();


        //LinkedNode sumNode = addTwoNumbers(nbr1, nbr2, 0);
       // LinkedNode sumNode = addTwoNumbersReverse(nbr1, nbr2, 0, null);

        LinkedNode sumNode = addTwoNumberIteration(nbr1, nbr2);
        sumNode.printList();

    }
}
