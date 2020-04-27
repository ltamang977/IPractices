package org.lv.ipractices.leetcodejune;

public class _24_SwapNodesInPair_M {



    public static ListNode swapNodesInLinkedList(ListNode head){

        ListNode curr = head;

        ListNode swapDummy = new ListNode(0);//just for handle
        //ListNode swapHead = swapDummy.next;
        ListNode prev = swapDummy;

       /* if(head!=null && head.next!=null){
            swapHead = head.next;
        }*/


        while(curr!=null && curr.next!=null){
            ListNode next = curr.next.next;
            ListNode first = curr;
            ListNode second = curr.next;

            second.next = first;
            first.next = null;
            prev.next = second;
            prev=first;
            curr = next;
        }

        if(curr!=null){
            prev.next = curr;
        }

        return swapDummy.next;

    }


    public static void printNodes(ListNode head){
        ListNode curr = head;

        System.out.println("Printting list");
        while(curr!=null){
            System.out.println("->"+curr.val);
            curr = curr.next;
        }
    }


    public static void main(String[] args){

        ListNode head = new ListNode(1);

        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;


        printNodes(head);
        ListNode swapHead = swapNodesInLinkedList( head);
        printNodes(swapHead);

    }
}
