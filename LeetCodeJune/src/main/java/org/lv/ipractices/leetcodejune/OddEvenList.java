package org.lv.ipractices.leetcodejune;

public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {

        if(head==null)
            return head;

        ListNode evenDummyHead = new ListNode(-1);
        ListNode even = evenDummyHead;

        ListNode curr = head;

        //move forward until finding odd
        while(curr!=null && curr.val%2==2){
            ListNode next = curr.next;
            curr.next = null;
            even.next = curr;
            curr=next;
        }

        if(curr==null)
            return evenDummyHead.next;

        //at here means oddd node present
        while(curr!=null && curr.next!=null){
            if(curr.next.val%2==0){
                //even case
                ListNode next = curr.next.next;
                ListNode node = curr.next;
                node.next=null;
                even.next=node;
                even=even.next;
                curr.next = next;
            }else{
                curr=curr.next;
            }

        }

        curr.next = evenDummyHead.next;
        return head;


    }

    public static void printList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.println("->"+curr.val);
            curr=curr.next;
        }
    }

    public static void main(String[] args){

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next=two;
        two.next = three;
        three.next=four;
        four.next = five;

        printList(one);

        ListNode result = oddEvenList(one);
    }
}
