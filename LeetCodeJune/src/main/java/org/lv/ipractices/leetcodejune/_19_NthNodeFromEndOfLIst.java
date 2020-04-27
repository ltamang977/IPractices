package org.lv.ipractices.leetcodejune;

public class _19_NthNodeFromEndOfLIst {

    //ListNode

    public static ListNode nthNodeFromEnd(ListNode head, int n){

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;


        for(int i=0; i<n; i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }

        while(fast!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(prev==null){
            head = head.next;
        }else{
            prev.next = slow.next;
        }

        return head;


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
        head.next= new ListNode(2);
        int n = 1;

        ListNode removedHead = nthNodeFromEnd( head,  n);
        printNodes(removedHead);

    }


}
